package com.ypl.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 角色
 * </p>
 *
 * @author ypl
 * @since 2020-07-31
 */
public class UpmsRole extends Model<UpmsRole> {

    private static final long serialVersionUID=1L;

      /**
     * 编号
     */
        @TableId(value = "role_id", type = IdType.AUTO)
      private Integer roleId;

      /**
     * 角色名称
     */
      private String name;

      /**
     * 角色标题
     */
      private String title;

      /**
     * 角色描述
     */
      private String description;

      /**
     * 创建时间
     */
      private Long ctime;

      /**
     * 排序
     */
      private Long orders;

    private String tenantId;

    private Integer deptId;

    
    public Integer getRoleId() {
        return roleId;
    }

      public UpmsRole setRoleId(Integer roleId) {
          this.roleId = roleId;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public UpmsRole setName(String name) {
          this.name = name;
          return this;
      }
    
    public String getTitle() {
        return title;
    }

      public UpmsRole setTitle(String title) {
          this.title = title;
          return this;
      }
    
    public String getDescription() {
        return description;
    }

      public UpmsRole setDescription(String description) {
          this.description = description;
          return this;
      }
    
    public Long getCtime() {
        return ctime;
    }

      public UpmsRole setCtime(Long ctime) {
          this.ctime = ctime;
          return this;
      }
    
    public Long getOrders() {
        return orders;
    }

      public UpmsRole setOrders(Long orders) {
          this.orders = orders;
          return this;
      }
    
    public String getTenantId() {
        return tenantId;
    }

      public UpmsRole setTenantId(String tenantId) {
          this.tenantId = tenantId;
          return this;
      }
    
    public Integer getDeptId() {
        return deptId;
    }

      public UpmsRole setDeptId(Integer deptId) {
          this.deptId = deptId;
          return this;
      }

    @Override
    protected Serializable pkVal() {
          return this.roleId;
      }

    @Override
    public String toString() {
        return "UpmsRole{" +
              "roleId=" + roleId +
                  ", name=" + name +
                  ", title=" + title +
                  ", description=" + description +
                  ", ctime=" + ctime +
                  ", orders=" + orders +
                  ", tenantId=" + tenantId +
                  ", deptId=" + deptId +
              "}";
    }
}
