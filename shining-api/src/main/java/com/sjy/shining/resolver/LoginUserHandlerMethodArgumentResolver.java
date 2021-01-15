package com.sjy.shining.resolver;

import com.sjy.shining.annotation.LoginUser;
import com.sjy.shining.entity.UserVo;
import com.sjy.shining.interceptor.AuthorizationInterceptor;
import com.sjy.shining.service.ApiUserService;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

/**
 * 有@LoginUser注解的方法参数，注入当前登录用户
 *
 */
public class LoginUserHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    private ApiUserService userService;

    public void setUserService(ApiUserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.getParameterType().isAssignableFrom(UserVo.class) && parameter.hasParameterAnnotation(LoginUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer container,
                                  NativeWebRequest request, WebDataBinderFactory factory) throws Exception {
        //获取用户ID
        Object object = request.getAttribute(AuthorizationInterceptor.LOGIN_USER_KEY, RequestAttributes.SCOPE_REQUEST);
        if (object == null) {
            return null;
        }

        //获取用户信息
        UserVo user = userService.queryObject((Long) object);

        return user;
    }
}
