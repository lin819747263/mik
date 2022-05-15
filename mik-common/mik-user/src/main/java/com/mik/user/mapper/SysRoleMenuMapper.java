package com.mik.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mik.user.model.SysMenu;
import com.mik.user.model.SysRoleMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

/**
 * @author zlt
 * 角色菜单
 */
@Mapper
public interface SysRoleMenuMapper extends BaseMapper<SysRoleMenu> {

	List<SysMenu> findRoleMenu(@Param("roleIds") Set<Long> roleIds);
}
