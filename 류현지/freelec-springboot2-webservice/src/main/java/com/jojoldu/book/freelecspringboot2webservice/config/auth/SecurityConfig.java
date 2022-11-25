package com.jojoldu.book.freelecspringboot2webservice.config.auth;

import com.jojoldu.book.freelecspringboot2webservice.domain.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity //스프링 시큐리티 설정들 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()//h2-console 화면 사용하기 위해 해당 옵션들 disabled
                .and()
                    //[URL별 권한 관리] 설정 옵션 진입점
                    .authorizeRequests()
                    .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() //권한 관리 대상을 지정하는 옵션 - 전체 열람 권한
                    .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                    //위에서 별도 설정한 URL제외 나머지 URL 어떻게 처리 할 것인지
                    .anyRequest().authenticated() //나머지 URL은 인증된 사용자(=로그인 한 사람)에게만 보여줌
                .and()
                    //[로그아웃 기능] 설정 진입점
                    .logout()
                        .logoutSuccessUrl("/") //로그아웃 시 index.hmtl ("/")로 이동
                .and()
                    //[OAuth2 로그인 기능] 설정 진입점
                    .oauth2Login()
                        .userInfoEndpoint() //-> 여러 설정 중 로그인 성공 이후 사용자 정보 가져올 때 설정
                            .userService(customOAuth2UserService); //소셜 로그인 성공 시 후속조치 진행할 UserService 인터페이스 구현체 등록
    }
}
