@echo off
title directSale package[bisu]
color 02
set curdir=%~dp0
set curpackagedir=com.sibu.directSale.web\target
set packagename=com.sibu.directSale.web.war

rem ftp message
set ftpServer=120.25.63.145
set ftpUserName=ftpupload
set ftpUserPass=password

cd /d %curdir%
cd ..

echo start update code ===============================
call git pull origin master
echo end update code =================================

cd /d %curdir%
echo start Maven package =============================
call mvn package -Dmaven.test.skip=true
echo end Maven package ===============================

echo;
echo start upload ====================================
cd %curpackagedir%
echo open %ftpServer% >ftp.up
echo %ftpUserName%>>ftp.up
echo %ftpUserPass%>>ftp.up
echo bin >>ftp.up
echo put %packagename% >>ftp.up
echo bye >>ftp.up
FTP -s:ftp.up
del ftp.up /q
echo end upload========================================

echo;
pause