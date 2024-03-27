package com.aledma.springsecurity.jwt;

import com.aledma.springsecurity.service.CustomUserDetailsService;
import com.aledma.springsecurity.utils.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.security.Security;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final CustomUserDetailsService customUserDetailsService;
    private final JwtUtil jwtUtil;
    
    
    @Override
    /**
     * JWT 토큰 검증 필터
     */
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");
        
        // JWT가 헤더에 있는 경우
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){
            String token = authorizationHeader.substring(7);
            // JWT 유효성 검증
            if(jwtUtil.validateToken(token)){
                Long userId = jwtUtil.getUserId(token);
                
                // 유저와 토큰 일치시 userDetails 생성
                UserDetails userDetails = customUserDetailsService.loadUserByUsername(userId.toString());
                
                if(userDetails != null){
                    // UserDetails, Password, Role -> 접근권한 인증 Token 생성
                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    
                    // 현재 Request의 Security Context 접근 권한 설정
                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                }
            }
        }
        // 다음 필터로 넘기기
        filterChain.doFilter(request, response);
    }
}
