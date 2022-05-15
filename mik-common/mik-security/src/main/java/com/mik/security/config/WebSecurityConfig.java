package com.mik.security.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mik.security.filter.JWTAuthenticationFilter;
import com.mik.security.filter.SmsCodeAuthFilter;
import com.mik.security.handler.FailedHandler;
import com.mik.security.handler.SuccessHandler;
import com.mik.security.provider.SmsProvider;
import com.mik.security.provider.UserNameAndPwdProvider;
import com.mik.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public static final String[] AUTH_WHITELIST = new String[]{"/login"};
    @Autowired
    SuccessHandler successHandler;

    @Autowired
    FailedHandler failedHandler;

    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserNameAndPwdProvider userNameAndPwdProvider;
    @Autowired
    SmsProvider smsProvider;


    @Bean
    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder)
                .and()
                .authenticationProvider(smsProvider)
                .authenticationProvider(userNameAndPwdProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/login", "/sms/login").permitAll()
                .anyRequest().authenticated()
                .and().formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .successHandler(successHandler)
                .failureHandler(failedHandler)
                .and()
                .logout().permitAll()
                .and()
                .addFilterBefore(new SmsCodeAuthFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class)
                .addFilterAfter(new JWTAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger/**")
//                .antMatchers("/login")
                .antMatchers("/swagger-ui.html")
                .antMatchers("/webjars/**")
                .antMatchers("/v2/**")
                .antMatchers("/v2/api-docs-ext/**")
                .antMatchers("/swagger-resources/**")
                .antMatchers("/doc.html");
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
