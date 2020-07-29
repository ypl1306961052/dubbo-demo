echo "开始安装php"
wget -q -O - http://www.atomicorp.com/installers/atomic | sh
yum  install  php php-mysql php-xml  php-gd php-mbstring php-cli
php -v