package com.mik.security.filter;

import com.mik.security.token.SmsToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@Component
public class SmsCodeAuthFilter extends AbstractAuthenticationProcessingFilter {

    public static final String SPRING_SECURITY_FORM_MOBILE = "mobile";
    public static final String SPRING_SECURITY_FORM_CODE = "code";


//    @Autowired
    public SmsCodeAuthFilter(AuthenticationManager authenticationManager) {
        super(new AntPathRequestMatcher("/sms/login", "POST"));
        setAuthenticationManager(authenticationManager);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        String mobile = request.getParameter("mobile");

        if(mobile == null)
            mobile = "";

        SmsToken authRequest = new SmsToken(mobile);

        authRequest.setDetails(authenticationDetailsSource.buildDetails(request));

        return this.getAuthenticationManager().authenticate(authRequest);
    }
}
