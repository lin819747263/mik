package com.mik.user.controller;

import com.mik.core.model.CommonResult;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.user.dto.MenuListInput;
import com.mik.user.dto.MenuOutput;
import com.mik.user.dto.MenuSaveOrUpdateInput;
import com.mik.user.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
public class SysMenuController {

    @Autowired
    SysMenuService sysMenuService;

    @PostMapping("saveOrUpdateMenu")
    public CommonResult saveOrUpdateMenu(MenuSaveOrUpdateInput input) {
        sysMenuService.saveOrUpdateMenu(input);
        return CommonResult.success();
    }

    @PostMapping("listMenuPage")
    public CommonResult<PageResult<MenuOutput>> listMenuPage(MenuListInput input, PageInput pageInput) {
        return CommonResult.success(sysMenuService.listMenuPage(input, pageInput));
    }

    @PostMapping("delMenu")
    public CommonResult delMenu(Long id) {
        sysMenuService.delMenu(id);
        return CommonResult.success();
    }

    @PostMapping("getMenu")
    public CommonResult<MenuOutput> getMenu(Long id) {
        return CommonResult.success(sysMenuService.getMenu(id));
    }

    @PostMapping("/findAllMenu")
    public CommonResult<List<MenuOutput>> findAllMenu() {
        return CommonResult.success(sysMenuService.findAll());
    }

    @PostMapping("/findRoleMenu")
    public CommonResult<List<MenuOutput>> findRoleMenu(Long roleId) {
        return CommonResult.success(sysMenuService.findRoleMenu(roleId));
    }
}
