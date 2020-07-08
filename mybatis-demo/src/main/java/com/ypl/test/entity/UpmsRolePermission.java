package com.ypl.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色权限关联表
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
public class UpmsRolePermission extends Model<UpmsRolePermission> {

    private static final long serialVersionUID=1L;

      /**
     * 编号
     */
        @TableId(value = "role_permission_id", type = IdType.AUTO)
      private Integer rolePermissionId;

      /**
     * 角色编号
     */
      private Integer roleId;

      /**
     * 权限编号
     */
      private Integer permissionId;

    
    public Integer getRolePermissionId() {
        return rolePermissionId;
    }

      public UpmsRolePermission setRolePermissionId(Integer rolePermissionId) {
          this.rolePermissionId = rolePermissionId;
          return this;
      }
    
    public Integer getRoleId() {
        return roleId;
    }

      public UpmsRolePermission setRoleId(Integer roleId) {
          this.roleId = roleId;
          return this;
      }
    
    public Integer getPermissionId() {
        return permissionId;
    }

      public UpmsRolePermission setPermissionId(Integer permissionId) {
          this.permissionId = permissionId;
          return this;
      }

    @Override
    protected Serializable pkVal() {
          return this.rolePermissionId;
      }

    @Override
    public String toString() {
        return "UpmsRolePermission{" +
              "rolePermissionId=" + rolePermissionId +
                  ", roleId=" + roleId +
                  ", permissionId=" + permissionId +
              "}";
    }
}
