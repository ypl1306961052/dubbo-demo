#!/bin/bash
echo "---------------开始安装tocamt------------------"
echo "下载tomcat 8.5.57 ...."
tomcatName='tomcat.tar.gz'
tomcatTmp='tomcat'
wget -O $tomcatName https://mirrors.tuna.tsinghua.edu.cn/apache/tomcat/tomcat-8/v8.5.57/bin/apache-tomcat-8.5.57.tar.gz
echo "解压tomcat"
mkdir ./$tomcatTmp && tar -zxvf $tomcatName -C ./$tomcatTmp  --strip-components 1
./$tomcatTmp/bin/startup.sh
if [ $? -eq 0 ];then
  echo "启动tomcat成功"
  else
    echo "启动tomcat失败"
fi

