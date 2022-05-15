package com.mik.security.provider;

import com.mik.security.service.UserService;
import com.mik.security.token.SmsToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class SmsProvider implements AuthenticationProvider {

    @Autowired
    UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        SmsToken smsCodeAuthenticationToken = (SmsToken) authentication;
        UserDetails user = userService.loadUserByUsername((String)smsCodeAuthenticationToken.getPrincipal());

        SmsToken authenticationResult = new SmsToken(user,user.getAuthorities());
        authenticationResult.setDetails(smsCodeAuthenticationToken.getDetails());
        return authenticationResult;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return SmsToken.class.isAssignableFrom(aClass);
    }
}
