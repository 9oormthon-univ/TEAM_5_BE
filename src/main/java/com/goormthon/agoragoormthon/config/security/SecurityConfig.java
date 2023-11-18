package com.goormthon.agoragoormthon.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.IpAddressMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(c -> c.disable());
        http.cors(cors -> cors.configure(http));

//        Deprecated.....
//        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
//        http.formLogin().disable(); // 폼 로그인 비활성화
//        http.httpBasic().disable(); // HTTP 기본 인증 비활성화

        http.authorizeHttpRequests((authz) -> authz
                .requestMatchers(new AntPathRequestMatcher("/**")
                        , new AntPathRequestMatcher("/api/**")
                        , new AntPathRequestMatcher("/api/v1/**")).permitAll()
                .requestMatchers(new IpAddressMatcher("127.0.0.1")
                        , new IpAddressMatcher("15.165.101.70")).permitAll()
                .anyRequest().authenticated());

        // apigateway-service에서 토큰 검증 후 들어오기 때문에 필터 걸 필요 없음
        //http.addFilter(getAuthenticationFilter());

        http.headers(h -> h.frameOptions(f -> f.disable()).disable());
        return http.build();
    }
}
