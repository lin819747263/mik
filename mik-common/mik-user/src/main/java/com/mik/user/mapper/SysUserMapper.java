package com.mik.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mik.user.model.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户表 Mapper 接口
 *
 * @author zlt
 * @data 2018-10-29
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUser> {

}
