package com.mik.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mik.user.model.SysRole;
import com.mik.user.model.SysRoleUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zlt
 * 用户角色关系
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysRoleUser> {


    List<SysRole> findUserRoles(@Param("userId") Long userId);
}
