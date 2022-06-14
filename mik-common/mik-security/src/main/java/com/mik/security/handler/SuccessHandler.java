package com.mik.security.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mik.cache.template.RedisRepository;
import com.mik.core.util.JwtUtil;
import com.mik.core.constant.CommonConstant;
import com.mik.core.model.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
@Slf4j
public class SuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    RedisRepository redisRepository;
    @Autowired
    ObjectMapper objectMapper;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("登录成功");
        UserDetails user = (UserDetails)authentication.getPrincipal();
        String token = JwtUtil.generateToken(user.getUsername());

        response.setHeader(CommonConstant.TOKEN_HEADER, token);
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(CommonResult.success(authentication.getPrincipal())));
    }
}
