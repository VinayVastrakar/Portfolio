package com.vinay.portfolio_backend.Config;

import com.vinay.portfolio_backend.Filter.JwtRequestFilter;
import com.vinay.portfolio_backend.Service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private JwtRequestFilter jwtRequestFilter;

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }


    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests().requestMatchers("/admin/**").authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   JwtRequestFilter jwtRequestFilter) throws Exception {
        configure(http);  // Call the configure methods directly within the bean definition
        return http.build();
    }

    @SuppressWarnings("deprecation")
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


//    @Bean
//    public AuthenticationManager authenticationManagerBean(HttpSecurity http) throws Exception {
//        configure(http);  // Call the configure methods directly within the bean definition
//        return http.build().authenticationManager();
//    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationManagerBuilder auth) throws Exception {
        return auth.build();
    }

}
