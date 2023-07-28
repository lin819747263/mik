package com.mik.user.controller;

import com.mik.core.model.Result;
import com.mik.core.model.PageInput;
import com.mik.core.model.PageResult;
import com.mik.user.dto.RoleOutput;
import com.mik.user.dto.UserListInput;
import com.mik.user.dto.UserOutput;
import com.mik.user.dto.UserSaveOrUpdateInput;
import com.mik.user.service.SysRoleUserService;
import com.mik.user.service.SysUserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class SysUserController {

    private SysUserService sysUserService;
    private SysRoleUserService sysRoleUserService;

    @PostMapping("saveOrUpdateUser")
    public Result saveOrUpdate(@RequestBody UserSaveOrUpdateInput sysUser) throws Exception {
        sysUserService.saveOrUpdateUser(sysUser);
        return Result.success();
    }

    @PostMapping(value = "deleteUser")
    public Result deleteUser(Long id) {
        sysUserService.deleteUser(id);
        return Result.success();
    }

    @PostMapping("listUserPage")
    public Result<PageResult<UserOutput>> listUserPage(UserListInput input, PageInput pageInput) {
        return Result.success(sysUserService.listUserPage(input, pageInput));
    }

    @PostMapping(value = "resetPwd")
    public Result resetPwd(Long id, String oldPwd, String newPwd) {
        sysUserService.resetPwd(id, oldPwd, newPwd);
        return Result.success();
    }

    @PostMapping(value = "setRole")
    public Result setRole(Long id, @RequestParam Set<Long> roleIds) {
        sysRoleUserService.setRole(id, roleIds);
        return Result.success();
    }

    @GetMapping("getUserById")
    public Result<UserOutput> getUserById(Long id) {
        return Result.success(sysUserService.getUserById(id));
    }

    @PostMapping("findUserRoles")
    public Result<List<RoleOutput>> findUserRoles(Long userId){
        return Result.success(sysUserService.findUserRoles(userId));
    }

}
