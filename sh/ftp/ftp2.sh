

sudo yum -y install vsftpd

sudo cp vsftpd.conf /etc/vsftpd/vsftpd.conf

sudo cp chroot_list /etc/vsftpd/chroot_list

sudo chkconfig --level 35 vsftpd on

sudo mkdir /usr/ftp/

sudo useradd -d /usr/ftp/ftpupload -s /sbin/nologin ftp

sudo passwd abc123456

sudo chmod -R 755 /usr/ftp/ftpupload

sudo chown -R ftp /usr/ftp/ftpupload

sudo setsebool -P sftpd_full_access 1

sudo setsebool -P tftp_home_dir 1

sudo firewall-cmd --zone=public --add-port=21/tcp --permanent

sudo firewall-cmd --zone=public --add-port=30000-30999/tcp --permanent

sudo systemctl start vsftpd

sed -i "s/SELINUX=enforcing/SELINUX=disabled/g" /etc/selinux/config