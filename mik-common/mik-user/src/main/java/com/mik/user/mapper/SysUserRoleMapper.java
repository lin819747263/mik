package com.mik.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mik.user.model.SysRoleUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zlt
 * 用户角色关系
 */
@Mapper
public interface SysUserRoleMapper extends BaseMapper<SysRoleUser> {


}
