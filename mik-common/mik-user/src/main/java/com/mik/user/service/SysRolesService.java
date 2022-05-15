package com.mik.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mik.core.PageUtil;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.db.query.QueryWrapperX;
import com.mik.user.convert.SysRoleConvert;
import com.mik.user.dto.RoleOutput;
import com.mik.user.dto.RoleSaveOrUpdateInput;
import com.mik.user.mapper.SysRoleMapper;
import com.mik.user.model.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysRolesService {

    @Autowired
    SysRoleMapper sysRoleMapper;

    public void saveOrUpdateRole(RoleSaveOrUpdateInput input) {
        SysRole role = SysRoleConvert.INSTANCE.convert(input);
        if (input.getId() != null){
            sysRoleMapper.updateById(role);
        }else{
            sysRoleMapper.insert(role);
        }
    }

    public void delRole(Long id) {
        sysRoleMapper.deleteById(id);
    }

    public PageResult<RoleOutput> listRolePage(String name, PageInput pageInput) {
        QueryWrapper<SysRole> queryWrapper = new QueryWrapperX<SysRole>().likeIfPresent("name",name);
        return SysRoleConvert.INSTANCE.convertPage(sysRoleMapper.selectPage(PageUtil.build(pageInput), queryWrapper));
    }

    public RoleOutput getRole(Long id) {
        return SysRoleConvert.INSTANCE.convert(sysRoleMapper.selectById(id));
    }
}
