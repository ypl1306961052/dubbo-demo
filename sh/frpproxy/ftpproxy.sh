fileNameTmp=ftpproxyTmp
fileName='ftpproxy'
echo "开始配置ftp代理程序"
echo "下载程序........."
wget -O $fileNameTmp http://www.ftpproxy.org/download/ftpproxy-current.tgz
mkdir ./$fileName && tar -zxvf $fileNameTmp -C ./$fileName --strip-components 1
rm -rf ./${fileNameTmp}
cd ./${fileName}
make
make install
ftp.proxy -D 21 10.2.19.16:21
