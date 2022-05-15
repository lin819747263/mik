package com.mik.user.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.mik.db.model.BaseEntity;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * @author zlt
 * @date 2019/7/30
 */
@Setter
@Getter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@TableName("sys_role_menu")
public class SysRoleMenu extends BaseEntity<SysRoleMenu> {
	private Long roleId;
	private Long menuId;
}
