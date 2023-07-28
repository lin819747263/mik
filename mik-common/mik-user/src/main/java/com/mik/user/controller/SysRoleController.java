package com.mik.user.controller;

import com.mik.core.model.Result;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.user.dto.RoleOutput;
import com.mik.user.dto.RoleSaveOrUpdateInput;
import com.mik.user.service.SysRoleMenuService;
import com.mik.user.service.SysRolesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("role")
@AllArgsConstructor
public class SysRoleController {

    private SysRolesService sysRolesService;
    private SysRoleMenuService sysRoleMenuService;

    @PostMapping("saveOrUpdateRole")
    public Result saveOrUpdateRole(RoleSaveOrUpdateInput input){
        sysRolesService.saveOrUpdateRole(input);
        return Result.success();
    }
    @PostMapping("listRolePage")
    public Result<PageResult<RoleOutput>> listRolePage(String name, PageInput pageInput){
        return Result.success(sysRolesService.listRolePage(name, pageInput));
    }
    @PostMapping("delRole")
    public Result delRole(Long id){
        sysRolesService.delRole(id);
        return Result.success();
    }

    @PostMapping("setMenus")
    public Result setMenus(Long id, @RequestParam Set<Long> menuIds){
        sysRoleMenuService.setMenus(id, menuIds);
        return Result.success();
    }

    @PostMapping("getRole")
    public Result<RoleOutput> getRole(Long id){
        return Result.success(sysRolesService.getRole(id));
    }

}
