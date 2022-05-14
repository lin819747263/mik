package com.mik.user.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mik.core.PageUtil;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.db.query.QueryWrapperX;
import com.mik.user.convert.SysMenuConvert;
import com.mik.user.dto.MenuListInput;
import com.mik.user.dto.MenuOutput;
import com.mik.user.dto.MenuSaveOrUpdateInput;
import com.mik.user.mapper.SysMenuMapper;
import com.mik.user.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    public void saveOrUpdateMenu(MenuSaveOrUpdateInput input) {
        SysMenu sysMenu = SysMenuConvert.INSTANCE.convert(input);
        if(input.getId()!= null){
            sysMenuMapper.updateById(sysMenu);
        }else {
            sysMenuMapper.insert(sysMenu);
        }
    }

    public PageResult<MenuOutput> listMenuPage(MenuListInput input, PageInput pageInput) {
        QueryWrapper<SysMenu> queryWrapper = new QueryWrapperX<SysMenu>()
                .likeIfPresent("name", input.getName());
        return SysMenuConvert.INSTANCE.convertPage(sysMenuMapper.selectPage(PageUtil.build(pageInput), queryWrapper));
    }

    public void delMenu(Long id) {
        sysMenuMapper.deleteById(id);
    }
}
