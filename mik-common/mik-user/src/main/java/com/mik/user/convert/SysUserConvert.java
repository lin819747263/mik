package com.mik.user.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mik.core.model.PageResult;
import com.mik.user.dto.UserOutput;
import com.mik.user.dto.UserSaveOrUpdateInput;
import com.mik.user.model.SysUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SysUserConvert {
    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    SysUser convert(UserSaveOrUpdateInput input);

    UserOutput convert(SysUser input);

    @Mapping(source = "records", target = "data")
    PageResult<UserOutput> convertPage(IPage<SysUser> page);
}
