package com.mik.security.provider;

import com.mik.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserNameAndPwdProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
        UserDetails user = userService.loadUserByUsername((String)token.getPrincipal());

        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }

        if(!passwordEncoder.matches((String) token.getCredentials(), user.getPassword())){
            throw new UsernameNotFoundException("用户名或者密码错误");
        }

        UsernamePasswordAuthenticationToken authenticationResult = new UsernamePasswordAuthenticationToken(user,user.getAuthorities());
        authenticationResult.setDetails(authenticationResult.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
