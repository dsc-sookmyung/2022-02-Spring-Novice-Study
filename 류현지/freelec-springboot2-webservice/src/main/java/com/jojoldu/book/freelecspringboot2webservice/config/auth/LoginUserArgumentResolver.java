package com.jojoldu.book.freelecspringboot2webservice.config.auth;

import com.jojoldu.book.freelecspringboot2webservice.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    private final HttpSession httpSession;

    @Override
    //컨트롤러 메서드의 특정 파라미터를 지원하는지 확인 -> 참/거짓 return
    public boolean supportsParameter(MethodParameter parameter) {
        // 파라미터에 @LoginUser 어노테이션 붙어어있으면 true
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        // 파라미터 클래스 타입 == SessionUser 인지 확인 -> true
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        // 둘다 true일 경우 true 리턴
        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        return httpSession.getAttribute("user"); //파라미터로 전달할 객체 생성 (세션에서 객체 가져옴)
    }

}
