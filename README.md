# empSystem
企业实训：通用后台管理项目

Github地址：https://github.com/Zpss2021/empSystem
# 写在最前
本项目限于原作者水平，上传时各个方面功能都不完善，只能作为一个小案例参考，可能对刚刚接触Java后端开发的朋友有帮助，故上传之。自述文档也尽量写的详细一些。
# 介绍
某双非大二的综合工程实践项目，用Java SSM + LayUI 实现了通用后台管理项目人事管理功能。前端代码由任课教师提供（项目src/main/webapp 文件夹中的内容）
## 背景
作为学校卓越计划的教学内容，这门实训居然是和Java基础同时开的课。当时作者只会一点面向对象写法，框架、设计模式都一窍不通，刚开始根本招架不住，只能跟着企业来的老师敲，所以代码质量堪忧。
不过敲得多了，对项目是怎么跑起来的也总算有点认识了。
### 收获
- 前后端的概念+前后端分离思想
- Java Web常见的技术栈
- Java常用语言框架功能及其配置
- 前后端通信，数据库通信（增删改查）的方式
- 软件工程MVC设计模式[^1]思想
- 查询帮助文档的方式
- 善用搜索和IDE快捷键

# 开发环境及简介
## Windows 10/11
常见的操作系统
## Intellij IDEA 2022.3.1
Java开发常用的IDE，Jetbrains出品；提供了Maven webapp项目生成器的支持；专业版有数据库可视化管理软件，可以申请学生认证免费使用
## MySQL 8.0.28
最常用的数据库之一
## HeidiSQL
最常见的数据库管理软件之一，主要用来导入SQL表和调错
## 项目管理工具 Maven
构建项目需要用到很多第三方的类库，需要引入大量的jar包，手动管理非常麻烦；Maven为构建项目提供了解决方案，其中pom.xml是Maven的核心配置，在里面配置需要的jar包。构建项目时Maven会读取该文件，并从仓库中下载相应的Jar包。
## 语言框架 SSM
- Spring：一个分层的Java SE/EE 一站式轻量级开源框架，其核心是控制反转（IoC）和面向切面（AOP）， 需配置spring.xml
- SpringMVC：基于Spring提供了MVC设计模式开发的支持，需配置springmvc.xml
- MyBatis：一个广泛应用的持久层框架，通过XML或注解来配置和映射原始类型、接口和 Java POJO 为数据库中的记录，需配置mybatis.xml和mysqlHelper.properties
## 其他类库依赖
这里介绍几个功能性的依赖，其他类库和具体使用版本可以在pom.xml中查看
- junit : 用于代码单元测试，示例代码可查看src/test/
- log4j : 一个功能强大的日志组件，需配置log4j.properties
- pagehelper : mybatis提供的一个分页插件，在mybatis.xml中配置
- druid : 阿里的数据库连接池

# 怎么把项目跑起来
1. 依赖安装：JDK 11、Maven 11、 MySQL 8.0.28，具体配置步骤从略；
2. 用HeidiSQL等软件连接MySQL数据库，导入数据库表，并将mysqlHelper.properties中的配置修改成自己数据库的账号密码
3. 用IDEA打开项目，首次运行会下载Maven中配置好的依赖项；
4. 项目默认运行在8080端口，用浏览器打开 http://localhost:8080 即可进入系统首页。

# 项目预览
![image](https://img2023.cnblogs.com/blog/2908723/202301/2908723-20230116060251351-87550089.png)
![image](https://img2023.cnblogs.com/blog/2908723/202301/2908723-20230116060305081-1524239823.png)
![image](https://img2023.cnblogs.com/blog/2908723/202301/2908723-20230116060313428-2013261613.png)

[^1]:Model-View-Controller(模型-视图-控制器)设计模式。用于应用程序的分层开发
