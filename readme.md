# 基于SpringCloud的商城模板

## 1.说明

1. 请访问Realease版本
2. 本模板项目只包含后端
3. powerdesigner文件夹包含数据库设计
4. 依赖以下模块
   - Nacos集群服务，端口号8802
   - Sentinel服务降级，默认端口8080，8719
   - Seata分布式事务，默认端口，注册到Nacos中
   - Mysql数据库8.X版本，默认端口3306，账号root，密码root
   - Redis，默认端口，没有密码
5. 主模块如下
   - Gateway网关服务，负责路由、过滤、鉴权。暴露给nginx反向代理，端口号8831。
   - AuthorizeServer认证服务，负责登录、颁发token、认证。端口号9801。
   - UserServer用户服务，端口号9811。
   - OrderServer订单服务，端口号9821。
   - ProductServer商品服务，端口号9831。
   - AdminServer管理员中心，端口号9841。
6. 利用以上模块简单描述以下用户下单流程（只绘制了成功的流程）：

![下单](https://github.com/githubzsy/com.zhoushiya.shop/blob/master/%E6%B5%81%E7%A8%8B%E5%9B%BE/%E4%B8%8B%E5%8D%95.png)
