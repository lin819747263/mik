package com.mik.user.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.mik.core.model.PageResult;
import com.mik.user.dto.MenuOutput;
import com.mik.user.dto.MenuSaveOrUpdateInput;
import com.mik.user.model.SysMenu;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SysMenuConvert {
    SysMenuConvert INSTANCE = Mappers.getMapper(SysMenuConvert.class);

    SysMenu convert(MenuSaveOrUpdateInput input);

    MenuOutput convert(SysMenu input);

    List<MenuOutput> convert(List<SysMenu> input);

    @Mapping(source = "records", target = "data")
    PageResult<MenuOutput> convertPage(IPage<SysMenu> page);
}
