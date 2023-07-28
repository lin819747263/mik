package com.mik.user.controller;

import com.mik.core.model.Result;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.user.dto.MenuListInput;
import com.mik.user.dto.MenuOutput;
import com.mik.user.dto.MenuSaveOrUpdateInput;
import com.mik.user.service.SysMenuService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("menu")
@AllArgsConstructor
public class SysMenuController {

    private SysMenuService sysMenuService;

    @PostMapping("saveOrUpdateMenu")
    public Result saveOrUpdateMenu(MenuSaveOrUpdateInput input) {
        sysMenuService.saveOrUpdateMenu(input);
        return Result.success();
    }

    @PostMapping("listMenuPage")
    public Result<PageResult<MenuOutput>> listMenuPage(MenuListInput input, PageInput pageInput) {
        return Result.success(sysMenuService.listMenuPage(input, pageInput));
    }

    @PostMapping("delMenu")
    public Result delMenu(Long id) {
        sysMenuService.delMenu(id);
        return Result.success();
    }

    @PostMapping("getMenu")
    public Result<MenuOutput> getMenu(Long id) {
        return Result.success(sysMenuService.getMenu(id));
    }

    @PostMapping("findAllMenu")
    public Result<List<MenuOutput>> findAllMenu() {
        return Result.success(sysMenuService.findAll());
    }

    @PostMapping("findRoleMenu")
    public Result<List<MenuOutput>> findRoleMenu(Long roleId) {
        return Result.success(sysMenuService.findRoleMenu(roleId));
    }
}
