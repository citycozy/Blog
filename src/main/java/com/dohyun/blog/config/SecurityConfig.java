package com.dohyun.blog.config;

import com.dohyun.blog.security.handler.CustomAuthenticationFailureHandler;
import com.dohyun.blog.security.handler.CustomAuthenticationSuccessHandler;
import com.dohyun.blog.security.handler.CustomLogoutSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private static final String[] allowUrls = {"/api/users/signup", "/api/users/login"};

    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;
    private final CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
    private final CustomLogoutSuccessHandler customLogoutSuccessHandler;

    public SecurityConfig(
            CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler,
            CustomAuthenticationFailureHandler customAuthenticationFailureHandler,
            CustomLogoutSuccessHandler customLogoutSuccessHandler) {
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
        this.customAuthenticationFailureHandler = customAuthenticationFailureHandler;
        this.customLogoutSuccessHandler = customLogoutSuccessHandler;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(
                        authorize ->
                                authorize
                                        .requestMatchers(allowUrls)
                                        .permitAll()
                                        .anyRequest()
                                        .authenticated())
                .formLogin(
                        auth ->
                                auth.loginProcessingUrl("/api/users/login")
                                        .failureHandler(customAuthenticationFailureHandler)
                                        .successHandler(customAuthenticationSuccessHandler)
                                        .permitAll())
                .logout(
                        logout ->
                                logout.logoutUrl("/api/users/logout")
                                        .logoutSuccessHandler(customLogoutSuccessHandler)
                                        .invalidateHttpSession(true)
                                        .deleteCookies("JSESSIONID"))
                .sessionManagement(
                        session -> session.maximumSessions(1).maxSessionsPreventsLogin(true))
                .sessionManagement(session -> session.sessionFixation().changeSessionId())
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
