package com.mik.user.controller;

import com.mik.core.model.CommonResult;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.user.dto.RoleOutput;
import com.mik.user.dto.UserListInput;
import com.mik.user.dto.UserOutput;
import com.mik.user.dto.UserSaveOrUpdateInput;
import com.mik.user.service.SysRoleUserService;
import com.mik.user.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("user")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleUserService sysRoleUserService;

    @PostMapping("/saveOrUpdateUser")
    public CommonResult saveOrUpdate(@RequestBody UserSaveOrUpdateInput sysUser) throws Exception {
        sysUserService.saveOrUpdateUser(sysUser);
        return CommonResult.success();
    }

    @PostMapping(value = "deleteUser")
    public CommonResult deleteUser(Long id) {
        sysUserService.deleteUser(id);
        return CommonResult.success();
    }

    @PostMapping("/listUserPage")
    public CommonResult<PageResult<UserOutput>> listUserPage(UserListInput input, PageInput pageInput) {
        return CommonResult.success(sysUserService.listUserPage(input, pageInput));
    }

    @PostMapping(value = "resetPwd")
    public CommonResult resetPwd(Long id, String oldPwd, String newPwd) {
        sysUserService.resetPwd(id, oldPwd, newPwd);
        return CommonResult.success();
    }

    @PostMapping(value = "setRole")
    public CommonResult setRole(Long id, @RequestParam Set<Long> roleIds) {
        sysRoleUserService.setRole(id, roleIds);
        return CommonResult.success();
    }

    @GetMapping("/getUserById")
    public CommonResult<UserOutput> getUserById(Long id) {
        return CommonResult.success(sysUserService.getUserById(id));
    }

    @PostMapping("/findUserRoles")
    public CommonResult<List<RoleOutput>> findUserRoles(Long userId){
        return CommonResult.success(sysUserService.findUserRoles(userId));
    }

}
