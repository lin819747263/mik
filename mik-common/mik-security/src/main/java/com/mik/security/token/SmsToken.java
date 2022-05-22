package com.mik.security.token;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SmsToken extends AbstractAuthenticationToken {

    private Object principal;
    private Object credentials;

    public SmsToken(String mobile, String credentials) {
        super(null);
        this.credentials = credentials;
        this.principal = mobile;
        setAuthenticated(false);
    }

    public SmsToken(Object principal, Collection<? extends GrantedAuthority> authorities) {
        super(authorities);
        this.principal = principal;
        super.setAuthenticated(true); // must use super, as we override
    }

    @Override
    public Object getCredentials() {
        return credentials;
    }

    @Override
    public Object getPrincipal() {
        return principal;
    }
}
