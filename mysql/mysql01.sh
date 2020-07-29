echo "-----------------------start install mysql----------------------"
yum -y install gcc gcc-c++ ncurses ncurses-devel openssl openssl-devel libtool*
mkdir -p /data/dbdata
if [ `grep "mysql" /etc/passwd | wc -l` -eq 0 ];then
echo "adding user mysql"
/usr/sbin/groupadd mysql
/usr/sbin/useradd -g mysql mysql
else
echo "mysql user is exist"
fi

wget http://downloads.mysql.com/archives/mysql-5.1/mysql-5.1.73.tar.gz
echo "tar xzvf mysql-5.1.73.tar.gz"
tar xzvf mysql-5.1.73.tar.gz
cd mysql-5.1.73
echo "configuring mysql,please wait-----------------"
./configure '--prefix=/usr/local/mysql' '--localstatedir=/data/dbdata/' '--with-unix-socket-path=/usr/local/mysql/tmp/mysql.sock' '--with-charset=utf8' '--with-extra-charsets=complex' '--with-pthread' '--enable-thread-safe-client' '--with-ssl' '--with-client-ldflags=-all-static' '--with-mysqld-ldflags=-all-static' '--with-plugins=partition,federated,innobase,csv,blackhole,myisam,innodb_plugin,heap,archive' '--enable-shared' '--enable-assembler'

if [ $? -ne 0 ];then
echo "configure filed ,please check it out!"
exit 1
fi

echo "make mysql, please wait for 20 minutes"
make
if [ $? -ne 0 ];then
echo "make filed ,please check it out!"
exit 1
fi

make install

chown -R mysql:mysql /usr/local/mysql
chown -R mysql.mysql /data/dbdata/

/usr/local/mysql/bin/mysql_install_db --user=mysql

cp ../my.cnf /etc/my.cnf

cp /usr/local/mysql/share/mysql/mysql.server /etc/rc.d/init.d/mysqld
chkconfig --add mysqld
chkconfig --level 2345 mysqld on

echo "mysql starting"
/etc/rc.d/init.d/mysqld start
if [ $? -ne 0 ];then
echo "mysql start filed ,please check it out!"
else
echo "mysql start successful,congratulations!"
fi
alias mysql=/usr/local/mysql/bin/mysql
#set password for root@10.2.19.6 = password('de2e1ff3efaa532e');
#update user set password=password('de2e1ff3efaa532e') where user='root' and host='localhost';