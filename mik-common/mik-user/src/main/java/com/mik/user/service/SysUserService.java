package com.mik.user.service;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mik.core.PageUtil;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.db.query.QueryWrapperX;
import com.mik.user.convert.SysRoleConvert;
import com.mik.user.convert.SysUserConvert;
import com.mik.user.dto.RoleOutput;
import com.mik.user.dto.UserListInput;
import com.mik.user.dto.UserOutput;
import com.mik.user.dto.UserSaveOrUpdateInput;
import com.mik.user.mapper.SysUserMapper;
import com.mik.user.mapper.SysUserRoleMapper;
import com.mik.user.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Autowired
    SysUserRoleMapper sysUserRoleMapper;

    public void saveOrUpdateUser(UserSaveOrUpdateInput input) {
        SysUser sysUser = new SysUser();
        BeanUtil.copyProperties(input, sysUser);
        if(input.getId()!= null){
            sysUserMapper.updateById(sysUser);
        }else {
            sysUserMapper.insert(sysUser);
        }

    }

    public PageResult<UserOutput> listUserPage(UserListInput input, PageInput pageInput) {

        QueryWrapper<SysUser> wrapper = new QueryWrapperX<SysUser>()
                .likeIfPresent("username", input.getUsername())
                .likeIfPresent("nickname", input.getNickname())
                .likeIfPresent("mobile", input.getMobile());

        return SysUserConvert.INSTANCE.convertPage(sysUserMapper.selectPage(PageUtil.build(pageInput), wrapper));
    }

    public void deleteUser(Long id) {
        sysUserMapper.deleteById(id);
    }

    public UserOutput getUserById(Long id) {
        return SysUserConvert.INSTANCE.convert(sysUserMapper.selectById(id));
    }

    public void resetPwd(Long id, String oldPwd, String newPwd) {
        SysUser user = sysUserMapper.selectById(id);
        user.setPassword(newPwd);
        sysUserMapper.updateById(user);
    }


    public SysUser getByUserNameOrMobile(String principal){
        QueryWrapper<SysUser> wrapper = new QueryWrapperX<SysUser>()
                .eq("username", principal)
                .or()
                .eq("mobile", principal);
        return sysUserMapper.selectOne(wrapper);
    }

    public List<RoleOutput> findUserRoles(Long userId){
        return SysRoleConvert.INSTANCE.convert(sysUserRoleMapper.findUserRoles(userId));
    }
}
