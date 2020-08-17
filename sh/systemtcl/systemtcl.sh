#一、systemctl理解
#Linux 服务管理两种方式service和systemctl
#
#systemd是Linux系统最新的初始化系统(init),作用是提高系统的启动速度，尽可能启动较少的进程，尽可能更多进程并发启动。
#
#systemd对应的进程管理命令是systemctl
#
#
#
#1. systemctl命令兼容了service
#即systemctl也会去/etc/init.d目录下，查看，执行相关程序
#
systemctl redis start
#
systemctl redis stop
#
## 开机自启动
#
systemctl enable redis
#2. systemctl命令管理systemd的资源Un