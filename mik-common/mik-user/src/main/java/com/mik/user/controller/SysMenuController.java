package com.mik.user.controller;

import com.mik.core.model.CommonResult;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.user.dto.MenuListInput;
import com.mik.user.dto.MenuOutput;
import com.mik.user.dto.MenuSaveOrUpdateInput;
import com.mik.user.service.SysMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    public CommonResult<PageResult<MenuOutput>> listMenuPage(MenuListInput input, PageInput pageInput) {
        return CommonResult.success(sysMenuService.listMenuPage(input, pageInput));
    }

    public CommonResult delMenu(Long id) {
        sysMenuService.delMenu(id);
        return CommonResult.success();
    }

    //    @ApiOperation(value = "查询所有菜单")
    @GetMapping("/findAllMenu")
    public void findAllMenu() {

    }
}
