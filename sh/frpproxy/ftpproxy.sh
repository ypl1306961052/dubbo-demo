

fileName=ftpProxy
fileNameTmp='ftpproxy'
echo "开始配置ftp代理程序"
echo "下载程序........."
wget -O $fileName http://www.ftpproxy.org/download/ftpproxy-current.tgz
mkdir ./$fileNameTmp && tar -zxvf $fileName -C ./$fileNameTmp --strip-components 1
cd ./${fileNameTmp} || exit
make
mkdir /usr/local/man
sudo make install
