

rpm -qa|grep vsftpd
#安装ftp
yum -y install vsftpd
# 开启服务号
service vsftpd start
#开启启动
chkconfig --level 35 vsftpd

#sshpass -p 'G$IySsa@7' ssh root@10.2.19.16
#sshpass -p 'G$IySsa@7' scp -P 22 -r /data/war/* root@10.2.19.6:/data/tomcat/webapps/
#sshpass -p 'G$IySsa@7' scp -P 22 -r /data/service/* root@10.2.19.11:/data/service/health/
#添加用户
useradd ftp -d /usr/local/nginx/html -s /sbin/nologin
#显示 vsftps是否启动
#service vsftpd start
service vsftpd status