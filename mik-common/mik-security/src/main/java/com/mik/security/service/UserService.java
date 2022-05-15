package com.mik.security.service;

import com.mik.user.model.SysUser;
import com.mik.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String principal) throws UsernameNotFoundException {
        SysUser output = sysUserService.getByUserNameOrMobile(principal);
        if (output == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return new User(principal, output.getPassword(), new ArrayList<>());
    }
}
