package com.mik.user.service;

import com.mik.user.mapper.SysRoleMenuMapper;
import com.mik.user.model.SysRoleMenu;
import com.mik.user.model.SysRoleUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class SysRoleMenuService {

    @Autowired
    private SysRoleMenuMapper sysRoleMenuMapper;

    @Transactional
    public void setMenus(Long id, Set<Long> menuIds) {
        List<SysRoleUser> roleUsers = new ArrayList<>();
        for (Long menuId : menuIds) {
            sysRoleMenuMapper.insert(new SysRoleMenu().setRoleId(id).setMenuId(menuId));
        }
    }

    public void getRole(Long id) {
    }
}
