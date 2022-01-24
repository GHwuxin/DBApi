# DBApi

![](https://gitee.com/freakchicken/db-api/badge/star.svg)
![](https://gitee.com/freakchicken/db-api/badge/fork.svg?theme=gvp)
![](https://img.shields.io/github/stars/freakchick/DBApi.svg?logo=GitHub)
![](https://img.shields.io/github/forks/freakchick/DBApi.svg?logo=GitHub)
![](https://img.shields.io/github/watchers/freakchick/DBApi.svg?logo=GitHub)
![](https://img.shields.io/github/license/freakchick/DBApi.svg)

[![EN doc](https://img.shields.io/badge/document-English-blue.svg)](README.md)
[![CN doc](https://img.shields.io/badge/文档-中文版-blue.svg)](README_zh_CN.md)

## 介绍

- 快速生成数据库的http接口服务，零代码开发，只需编写sql，就可以生成http api服务。是数据库的上层应用，方便数据库数据对外发布http服务
- 体验地址： `http://101.34.234.234:8520/` 。  默认账户： admin/admin
## 使用场景

- BI报表、数据可视化大屏的后端接口快速开发；
- 前端程序员快速开发后端接口进行接口联调；
- 企业数据资产对外快速发布http服务及统一管理
- 企业数据接口的统一管理中心

## 特点
- 开箱即用，不需要编程，不需要依赖其他软件（只需要java运行环境）
- 支持动态添加、修改api；支持api上线、下线管理
- 支持API级别的访问权限控制，支持IP白名单、黑名单控制
- 支持多数据源连接，支持动态添加、修改、删除数据源
- 支持所有类型数据库（JDBC连接方式），包括mysql/sqlserver/postgreSql/hive/kylin/clickhouse/oracle等等
- 支持动态sql，类似mybatis的动态sql
- 支持sql编辑调试，包括动态sql的调试
- 支持API结果缓存，支持缓存开启/关闭（通过缓存插件实现）
- 支持自定义代码逻辑的数据转换，比如数据脱敏
- 支持API配置导入导出，方便测试环境到生产环境的API迁移

## 视频教程
[查看视频教程](https://www.bilibili.com/video/BV1zL411G7Qh)

## 安装教程

- 依赖java环境，需要安装jdk8+，并配置java环境变量
- 下载地址： [天翼云盘](https://cloud.189.cn/t/Jza2MzeEZVNv) ，或者在发行版页面下载

### 1. tar包安装

- 下载`DBApi-[version]-bin.tar.gz`包
- 解压tar包，修改`conf/application.properties`文件中的配置:

- （可选）如果您想使用自己的mysql作为元数据库，请修改`conf/application.properties`文件中的以下配置

```properties
# 如果您使用了mysql作为自己的元数据库，启动前请在数据库执行初始化sql脚本，脚本在sql/目录下
spring.datasource.driver-class-name=
spring.datasource.url=
spring.datasource.username=
spring.datasource.password=
```

- linux操作命令

```shell
# 前台启动
sh bin/dbApi.sh start
# 后台启动
sh bin/dbApi.sh -d start
# 关闭后台启动的进程
sh bin/dbApi.sh stop
```

- windows操作命令

```shell
# 前台启动, 或者直接双击 `bin/dbApi.bat` 文件启动
bin/dbApi.bat
```
- 启动后浏览器访问 `http://ip:8520` ，默认登录账户： admin/admin

### 2.docker安装

```shell script
docker run -d -p 8520:8520 freakchicken/db-api
```

- 启动后浏览器访问 `http://ip:8520` ，默认登录账户： admin/admin

## 软件截图
![](https://freakchicken.gitee.io/images/dbApi/20210904/api.png)
![](https://freakchicken.gitee.io/images/dbApi/20210502/datasource_create.png)
![](https://freakchicken.gitee.io/images/dbApi/20210803/api_edit.png)
![](https://freakchicken.gitee.io/images/dbApi/20210803/sql_run.png)
![](https://freakchicken.gitee.io/images/dbApi/20210803/api_list.png)
![](https://freakchicken.gitee.io/images/dbApi/20210502/group.png)
![](https://freakchicken.gitee.io/images/dbApi/20210502/request.png)

![](https://freakchicken.gitee.io/images/dbApi/20210502/token_add.png)
![](https://freakchicken.gitee.io/images/dbApi/20210502/token.png)
![](https://freakchicken.gitee.io/images/dbApi/20210502/token_auth.png)
![](https://freakchicken.gitee.io/images/dbApi/20210502/docs.png)
![](https://freakchicken.gitee.io/images/dbApi/20210803/ip.png)

## 使用说明

请阅读 [详细使用说明](./dbapi-assembly/docs/instruction.md)


## 插件开发
- 请阅读 [插件开发指南](./dbapi-assembly/docs/plugin%20development.md)
- 作者已经开发了字段加密插件和redis缓存插件，请阅读[案例demo](https://gitee.com/freakchicken/dbapi-plugin-demo)

## 二次开发
- 请阅读 [开发指南](./dbapi-assembly/docs/development.md)

## springboot集成

如果您想更加灵活的使用DBApi，在您自己的java springboot项目中使用代码配置接口，
请使用[dbApi-spring-boot-starter开源框架](https://gitee.com/freakchicken/dbApi-spring-boot-starter)

## 联系作者：

### 微信：
- 提问请先star支持一下，提问前请先把文档读一遍，文档里写过的问题不会回答
<div style="text-align: center"> 
<img src="https://freakchicken.gitee.io/images/kafkaui/wechat.jpg" width = "30%" />
</div>

### 微信交流群：

<div style="text-align: center"> 
<img src="https://freakchicken.gitee.io/images/dbApi/wechatGroup.png" width = "40%" />
</div>

### qq交流群：

<div style="text-align: center"> 
<img src="https://freakchicken.gitee.io/images/dbApi/qqgroup.jpg" width = "40%" />
</div>

### 捐赠：

开源不易，用爱发电，如果此项目帮助到您，请作者喝一杯咖啡
<div style="text-align: center"> 
<img src="https://freakchicken.gitee.io/images/kafkaui/wechatpay.jpg" width = "30%" />
<img src="https://freakchicken.gitee.io/images/kafkaui/alipay.jpg" width = "29%" />
</div>

## TODO
- 支持object、List<object> 类型参数
- 支持API调用记录监控
- 支持API报错邮件告警
- 数据源密码加密
- 集群版本开发，支持微服务注册consul/eureka/nacos
- api熔断支持
- 请求路由参数支持
- 流量监控支持，ip限流，分组限流

- 功能性api支持（RPC调用）
- 分库分表数据源支持（shardingSphere/mycat）