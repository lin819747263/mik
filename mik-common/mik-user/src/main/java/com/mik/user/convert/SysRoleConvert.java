package com.mik.user.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mik.core.model.PageResult;
import com.mik.user.dto.RoleOutput;
import com.mik.user.dto.RoleSaveOrUpdateInput;
import com.mik.user.model.SysRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysRoleConvert {
    SysRoleConvert INSTANCE = Mappers.getMapper(SysRoleConvert.class);

    SysRole convert(RoleSaveOrUpdateInput input);

    RoleOutput convert(SysRole input);

    List<RoleOutput> convert(List<SysRole> input);

    @Mapping(source = "records", target = "data")
    PageResult<RoleOutput> convertPage(IPage<SysRole> page);
}
