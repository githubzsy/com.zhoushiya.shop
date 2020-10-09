# 使用说明
## 1. 启动其它服务
```bash
# 启动nacos集群
cd D:\Program Files\nacos-server-1.3.2\nacos\bin
startup.cmd -d 3333
startup.cmd -d 4444
startup.cmd -d 5555
# 启动sentinel，使用默认Dashboard端口8080，默认通讯端口8719
cd D:\Program Files\sentinel
java -jar sentinel-dashboard-1.8.0.jar
# 启动seata，默认端口8091
cd D:\seata\1.3.0\seata\bin
seata-server.bat
# 启动nginx
cd D:\Program Files\nginx-1.19.2
nginx.exe
```