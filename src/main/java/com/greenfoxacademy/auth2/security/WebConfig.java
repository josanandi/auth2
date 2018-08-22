//package com.greenfoxacademy.auth2.security;
//
//import com.greenfoxacademy.auth2.service.JwtService;
//import io.jsonwebtoken.JwtParser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@Configuration
//@EnableGlobalMethodSecurity
//public class WebConfig extends WebSecurityConfigurerAdapter {
//
//    JwtService jwtService;
//    @Autowired
//    public WebConfig(JwtService jwtService) {
//        this.jwtService = jwtService;
//    }
//
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf()
//                .disable()
//                .authorizeRequests()
//                .antMatchers("/api/user/").permitAll()
//                .antMatchers("/api/auth/").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//
//        http.apply(new JwtFilterConfiguration(jwtService));
//    }
//}
