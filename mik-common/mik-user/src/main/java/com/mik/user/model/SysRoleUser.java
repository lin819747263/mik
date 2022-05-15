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
@TableName("sys_role_user")
public class SysRoleUser extends BaseEntity<SysRoleUser> {
	private Long userId;
	private Long roleId;
}
