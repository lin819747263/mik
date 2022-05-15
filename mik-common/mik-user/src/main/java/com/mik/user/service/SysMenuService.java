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
import com.mik.user.mapper.SysRoleMenuMapper;
import com.mik.user.model.SysMenu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class SysMenuService {

    @Autowired
    SysMenuMapper sysMenuMapper;

    @Autowired
    SysRoleMenuMapper sysRoleMenuMapper;

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

    public MenuOutput getMenu(Long id) {
        return SysMenuConvert.INSTANCE.convert(sysMenuMapper.selectById(id));
    }

    public List<MenuOutput> findAll() {
        return SysMenuConvert.INSTANCE.convert(sysMenuMapper.selectList(new QueryWrapper<SysMenu>().orderByAsc("sort")));
    }

    public List<MenuOutput> findRoleMenu(Long roleId) {
        List<MenuOutput> allMenuOutputs = findAll();
        List<MenuOutput> roleMenuOutputs = findRoleMenu(new HashSet<>(){
            {
                add(roleId);
            }});

        Map<Long, MenuOutput> map = roleMenuOutputs.stream().collect(Collectors.toMap(MenuOutput::getId, Function.identity()));

        for (MenuOutput output : allMenuOutputs){
            if(map.get(output.getId()) != null){
                output.setChecked(true);
            }
        }
        return allMenuOutputs;
    }

    public List<MenuOutput> findRoleMenu(Set<Long> roleIds){
        return SysMenuConvert.INSTANCE.convert(sysRoleMenuMapper.findRoleMenu(roleIds));
    }


}
