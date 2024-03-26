//package com.aledma.springsecurity.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
//
//@Configuration // 클래스를 구성 클래스로 표시.
//public class ProjectConfig extends SecurityConfigurerAdapter {
//
//    @Bean // 스프링 컨텍스트에 빈으로 추가하도록 스프링에 지시한다.
//    public UserDetailsService userDetailsService(){
//        var userDetailsService = new InMemoryUserDetailsManager(); // var 키워드는 구문을 간소하게 만들고, 세부 정보를 감춘다.
//        // InMemoryUserDetailsManager는 메모리에 자격 증명을 저장해서 스프링 시큐리티가 요청을 인증할 때 이용할 수 있게 한다.
//
//        var user = User.withUsername("john") // User 객체는 사용자를 나타내는 객체를 만드는 빌더 구현이다.
//                .password("12345")
//                .authorities("read")
//                .build();
//        userDetailsService.createUser(user);
//
//        return userDetailsService;
//    }
//
//    /*
//    기본 UserDetailService를 이용하면 PasswordEncoder도 자동 구성되지만,
//    UserDetailService 재정의하면 PasswordEncoder도 다시 선언해야 한다.
//     */
//
//    @Bean
//    public PasswordEncoder passwordEncoder(){
//        return NoOpPasswordEncoder.getInstance();
//    }
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//        http.httpBasic();
//        http.authorizeRequests()
//                .anyRequest().authenticated();
//    }
//}
