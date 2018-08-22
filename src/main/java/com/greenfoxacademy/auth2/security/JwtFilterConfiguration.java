//package com.greenfoxacademy.auth2.security;
//
//import com.greenfoxacademy.auth2.service.JwtService;
//
//import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.DefaultSecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//public class JwtFilterConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
//    private JwtService jwtService;
//
//    public JwtFilterConfiguration(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }
//
//    @Override
//    public void configure(HttpSecurity http) throws Exception {
//        JwtFilter customFilter = new JwtFilter(jwtService);
//        http.addFilterBefore(customFilter, UsernamePasswordAuthenticationFilter.class);
//    }
//}
