package com.aledma.springsecurity.service;

import com.aledma.springsecurity.domain.user.Member;
import com.aledma.springsecurity.dto.CustomUserInfoDto;
import com.aledma.springsecurity.dto.LoginRequestDto;
import com.aledma.springsecurity.repository.MemberRepository;
import com.aledma.springsecurity.utils.JwtUtil;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Transactional
@Service
public class AuthService {
    private final JwtUtil jwtUtil;
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;
    private final ModelMapper modelMapper;

    public String login(LoginRequestDto dto){
        String email = dto.getEmail();
        String password = dto.getPassword();
        Member member = memberRepository.findMembersByEmail(email);
        if (member == null){
            throw new UsernameNotFoundException("이메일이 존재하지 않습니다.");
        }

        // 암호환된 password를 디코딩한 값과 입력한 패스워드 값이 다르면 null 반환
        if(!encoder.matches(password, member.getPassword())){
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        CustomUserInfoDto infoDto = modelMapper.map(member, CustomUserInfoDto.class);

        String accessToken = jwtUtil.createAccessToken(infoDto);
        return accessToken;
    }
}
