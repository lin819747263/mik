package com.mik.user.service;

import com.mik.user.mapper.SysUserRoleMapper;
import com.mik.user.model.SysRoleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleUserService {

    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    @Transactional
    public void setRole(Long id, Set<Long> roleIds) {
        List<SysRoleUser> roleUsers = new ArrayList<>();
        for (Long roleId : roleIds) {
            sysUserRoleMapper.insert(new SysRoleUser().setRoleId(roleId).setUserId(id));
        }
    }
}
