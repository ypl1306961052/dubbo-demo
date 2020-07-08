package com.ypl.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author ypl
 * @since 2020-07-08
 */
public class UpmsPermission extends Model<UpmsPermission> {

    private static final long serialVersionUID=1L;

      /**
     * 编号
     */
        @TableId(value = "permission_id", type = IdType.AUTO)
      private Integer permissionId;

      /**
     * 所属系统
     */
      private Integer systemId;

      /**
     * 所属上级
     */
      private Integer pid;

      /**
     * 名称
     */
      private String name;

      /**
     * 类型(1:目录,2:菜单,3:按钮)
     */
      private Integer type;

      /**
     * 权限值
     */
      private String permissionValue;

      /**
     * 路径
     */
      private String uri;

      /**
     * 图标
     */
      private String icon;

      /**
     * 状态(0:禁止,1:正常)
     */
      private Integer status;

      /**
     * 创建时间
     */
      private Long ctime;

      /**
     * 排序
     */
      private Long orders;

    private String tenantId;

    
    public Integer getPermissionId() {
        return permissionId;
    }

      public UpmsPermission setPermissionId(Integer permissionId) {
          this.permissionId = permissionId;
          return this;
      }
    
    public Integer getSystemId() {
        return systemId;
    }

      public UpmsPermission setSystemId(Integer systemId) {
          this.systemId = systemId;
          return this;
      }
    
    public Integer getPid() {
        return pid;
    }

      public UpmsPermission setPid(Integer pid) {
          this.pid = pid;
          return this;
      }
    
    public String getName() {
        return name;
    }

      public UpmsPermission setName(String name) {
          this.name = name;
          return this;
      }
    
    public Integer getType() {
        return type;
    }

      public UpmsPermission setType(Integer type) {
          this.type = type;
          return this;
      }
    
    public String getPermissionValue() {
        return permissionValue;
    }

      public UpmsPermission setPermissionValue(String permissionValue) {
          this.permissionValue = permissionValue;
          return this;
      }
    
    public String getUri() {
        return uri;
    }

      public UpmsPermission setUri(String uri) {
          this.uri = uri;
          return this;
      }
    
    public String getIcon() {
        return icon;
    }

      public UpmsPermission setIcon(String icon) {
          this.icon = icon;
          return this;
      }
    
    public Integer getStatus() {
        return status;
    }

      public UpmsPermission setStatus(Integer status) {
          this.status = status;
          return this;
      }
    
    public Long getCtime() {
        return ctime;
    }

      public UpmsPermission setCtime(Long ctime) {
          this.ctime = ctime;
          return this;
      }
    
    public Long getOrders() {
        return orders;
    }

      public UpmsPermission setOrders(Long orders) {
          this.orders = orders;
          return this;
      }
    
    public String getTenantId() {
        return tenantId;
    }

      public UpmsPermission setTenantId(String tenantId) {
          this.tenantId = tenantId;
          return this;
      }

    @Override
    protected Serializable pkVal() {
          return this.permissionId;
      }

    @Override
    public String toString() {
        return "UpmsPermission{" +
              "permissionId=" + permissionId +
                  ", systemId=" + systemId +
                  ", pid=" + pid +
                  ", name=" + name +
                  ", type=" + type +
                  ", permissionValue=" + permissionValue +
                  ", uri=" + uri +
                  ", icon=" + icon +
                  ", status=" + status +
                  ", ctime=" + ctime +
                  ", orders=" + orders +
                  ", tenantId=" + tenantId +
              "}";
    }
}
