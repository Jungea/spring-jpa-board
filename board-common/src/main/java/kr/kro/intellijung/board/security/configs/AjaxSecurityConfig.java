package kr.kro.intellijung.board.security.configs;

import kr.kro.intellijung.board.security.common.AjaxLoginAuthenticationEntryPoint;
import kr.kro.intellijung.board.security.filter.AjaxLoginProcessingFilter;
import kr.kro.intellijung.board.security.handler.AjaxAccessDeniedHandler;
import kr.kro.intellijung.board.security.handler.AjaxAuthenticationFailureHandler;
import kr.kro.intellijung.board.security.handler.AjaxAuthenticationSuccessHandler;
import kr.kro.intellijung.board.security.provider.AjaxAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity(debug = true)
@Configuration
@Order(0)
@RequiredArgsConstructor
public class AjaxSecurityConfig {

    private final UserDetailsService userDetailsService;

    @Bean
    public AuthenticationProvider ajaxAuthenticationProvider() {
        return new AjaxAuthenticationProvider(userDetailsService, passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http)
        throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .securityMatcher("/api/**")
            .authorizeHttpRequests(request -> request
                .requestMatchers("/api/messages").hasRole("MANAGER")
                .anyRequest().authenticated())
            .authenticationProvider(ajaxAuthenticationProvider())
            .exceptionHandling(handle -> handle
                .authenticationEntryPoint(new AjaxLoginAuthenticationEntryPoint())
                .accessDeniedHandler(ajaxAccessDeniedHandler()));

        customConfigurerAjax(http);

        return http.build();
    }

    private void customConfigurerAjax(HttpSecurity http) throws Exception {
        AuthenticationManager authenticationManager = http.getSharedObject(
            AuthenticationManager.class);
        http
            .apply(new AjaxLoginConfigurer<>())
            .successHandlerAjax(ajaxAuthenticationSuccessHandler())
            .failureHandlerAjax(ajaxAuthenticationFailureHandler())
            .setAuthenticationManager(authenticationManager)
            .loginProcessingUrl("/api/users/login");
    }

    @Bean
    public AccessDeniedHandler ajaxAccessDeniedHandler() {
        return new AjaxAccessDeniedHandler();
    }

    @Bean
    public AuthenticationSuccessHandler ajaxAuthenticationSuccessHandler() {
        return new AjaxAuthenticationSuccessHandler();
    }

    @Bean
    public AuthenticationFailureHandler ajaxAuthenticationFailureHandler() {
        return new AjaxAuthenticationFailureHandler();
    }

}
