package com.mik.user.controller;

import com.mik.core.model.CommonResult;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.user.dto.RoleOutput;
import com.mik.user.dto.RoleSaveOrUpdateInput;
import com.mik.user.service.SysRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("role")
public class SysRoleController {

    @Autowired
    SysRolesService sysRolesService;

    @PostMapping("saveOrUpdateRole")
    public CommonResult saveOrUpdateRole(RoleSaveOrUpdateInput input){
        sysRolesService.saveOrUpdateRole(input);
        return CommonResult.success();
    }
    @PostMapping("listRolePage")
    public CommonResult<PageResult<RoleOutput>> listRolePage(String name, PageInput pageInput){
        return CommonResult.success(sysRolesService.listRolePage(name, pageInput));
    }
    @PostMapping("delRole")
    public CommonResult delRole(Long id){
        sysRolesService.delRole(id);
        return CommonResult.success();
    }

}
