package com.ypl.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 用户
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
public class UpmsUser extends Model<UpmsUser> {

    private static final long serialVersionUID=1L;

      /**
     * 编号
     */
        @TableId(value = "user_id", type = IdType.AUTO)
      private Integer userId;

      /**
     * 帐号
     */
      private String username;

      /**
     * 密码MD5(密码+盐)
     */
      private String password;

      /**
     * 盐
     */
      private String salt;

      /**
     * 姓名
     */
      private String realname;

      /**
     * 头像
     */
      private String avatar;

      /**
     * 电话
     */
      private String phone;

      /**
     * 邮箱
     */
      private String email;

      /**
     * 性别
     */
      private Integer sex;

    private Integer deptId;

      /**
     * 状态(0:正常,1:锁定,2:失效)
     */
      private Integer locked;

      /**
     * 创建时间
     */
      private Long ctime;

      /**
     * 租户ID
     */
      private String tenantId;

    private Integer targetId;

    private Integer targetType;

    
    public Integer getUserId() {
        return userId;
    }

      public UpmsUser setUserId(Integer userId) {
          this.userId = userId;
          return this;
      }
    
    public String getUsername() {
        return username;
    }

      public UpmsUser setUsername(String username) {
          this.username = username;
          return this;
      }
    
    public String getPassword() {
        return password;
    }

      public UpmsUser setPassword(String password) {
          this.password = password;
          return this;
      }
    
    public String getSalt() {
        return salt;
    }

      public UpmsUser setSalt(String salt) {
          this.salt = salt;
          return this;
      }
    
    public String getRealname() {
        return realname;
    }

      public UpmsUser setRealname(String realname) {
          this.realname = realname;
          return this;
      }
    
    public String getAvatar() {
        return avatar;
    }

      public UpmsUser setAvatar(String avatar) {
          this.avatar = avatar;
          return this;
      }
    
    public String getPhone() {
        return phone;
    }

      public UpmsUser setPhone(String phone) {
          this.phone = phone;
          return this;
      }
    
    public String getEmail() {
        return email;
    }

      public UpmsUser setEmail(String email) {
          this.email = email;
          return this;
      }
    
    public Integer getSex() {
        return sex;
    }

      public UpmsUser setSex(Integer sex) {
          this.sex = sex;
          return this;
      }
    
    public Integer getDeptId() {
        return deptId;
    }

      public UpmsUser setDeptId(Integer deptId) {
          this.deptId = deptId;
          return this;
      }
    
    public Integer getLocked() {
        return locked;
    }

      public UpmsUser setLocked(Integer locked) {
          this.locked = locked;
          return this;
      }
    
    public Long getCtime() {
        return ctime;
    }

      public UpmsUser setCtime(Long ctime) {
          this.ctime = ctime;
          return this;
      }
    
    public String getTenantId() {
        return tenantId;
    }

      public UpmsUser setTenantId(String tenantId) {
          this.tenantId = tenantId;
          return this;
      }
    
    public Integer getTargetId() {
        return targetId;
    }

      public UpmsUser setTargetId(Integer targetId) {
          this.targetId = targetId;
          return this;
      }
    
    public Integer getTargetType() {
        return targetType;
    }

      public UpmsUser setTargetType(Integer targetType) {
          this.targetType = targetType;
          return this;
      }

    @Override
    protected Serializable pkVal() {
          return this.userId;
      }

    @Override
    public String toString() {
        return "UpmsUser{" +
              "userId=" + userId +
                  ", username=" + username +
                  ", password=" + password +
                  ", salt=" + salt +
                  ", realname=" + realname +
                  ", avatar=" + avatar +
                  ", phone=" + phone +
                  ", email=" + email +
                  ", sex=" + sex +
                  ", deptId=" + deptId +
                  ", locked=" + locked +
                  ", ctime=" + ctime +
                  ", tenantId=" + tenantId +
                  ", targetId=" + targetId +
                  ", targetType=" + targetType +
              "}";
    }
}
