package com.ypl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户角色关联表
 * </p>
 *
 * @author ypl
 * @since 2020-07-31
 */
public class UpmsUserRole extends Model<UpmsUserRole> {

    private static final long serialVersionUID=1L;

      /**
     * 编号
     */
        @TableId(value = "user_role_id", type = IdType.AUTO)
      private Integer userRoleId;

      /**
     * 用户编号
     */
      private Integer userId;

      /**
     * 角色编号
     */
      private Integer roleId;

    
    public Integer getUserRoleId() {
        return userRoleId;
    }

      public UpmsUserRole setUserRoleId(Integer userRoleId) {
          this.userRoleId = userRoleId;
          return this;
      }
    
    public Integer getUserId() {
        return userId;
    }

      public UpmsUserRole setUserId(Integer userId) {
          this.userId = userId;
          return this;
      }
    
    public Integer getRoleId() {
        return roleId;
    }

      public UpmsUserRole setRoleId(Integer roleId) {
          this.roleId = roleId;
          return this;
      }

    @Override
    protected Serializable pkVal() {
          return this.userRoleId;
      }

    @Override
    public String toString() {
        return "UpmsUserRole{" +
              "userRoleId=" + userRoleId +
                  ", userId=" + userId +
                  ", roleId=" + roleId +
              "}";
    }
}
