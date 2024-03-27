package com.aledma.springsecurity.service;

import com.aledma.springsecurity.domain.user.CustomUserDetails;
import com.aledma.springsecurity.domain.user.Member;
import com.aledma.springsecurity.dto.CustomUserInfoDto;
import com.aledma.springsecurity.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Transactional
@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final MemberRepository memberRepository;
    private final ModelMapper modelMapper;
    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        Member member = memberRepository.findById(Long.parseLong(id))
                .orElseThrow(() -> new UsernameNotFoundException("해당하는 유저가 없습니다."));

        CustomUserInfoDto userInfoDto = modelMapper.map(member, CustomUserInfoDto.class);

        return new CustomUserDetails(userInfoDto);
    }
}
