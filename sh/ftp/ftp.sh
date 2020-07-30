
#安装ftp
yum install vsftpd
# 开启服务号
service vsftpd start
#开启启动
chkconfig --level 35 vsftpd

#sshpass -p 'G$IySsa@7' ssh root@10.2.19.16
#sshpass -p 'G$IySsa@7' scp -P 22 -r /data/war/* root@10.2.19.6:/data/tomcat/webapps/
#sshpass -p 'G$IySsa@7' scp -P 22 -r /data/service/* root@10.2.19.11:/data/service/health/
#添加用户
useradd ftpadmin -s /sbin/nologin