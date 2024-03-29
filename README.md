#### 项目名称

​    《我的博客》

#### 项目背景

​	2019年之前一直都在写前端软件，已经写了5年了。早写时候一直都在思考，是不是开始要学一学后台。这个想法一直只是停留在思想层面，行动也有时间都不长。前些时候在B站无意中发现居然有很多学习资源，心想现在学习环境这么好如果还不学习岂不是有一点可惜了。

​	我的博客这个项目是跟随着视频学习写的。在这学习过程中如果学到了任何知识点，我都会用笔记，记录下来。

#### 编码环境

1. Win10系统下编写
2. Ide编译器
3. Maven 管理工具
4. git代码管理

#### 项目依赖库

1. Thymeleaf Spring Boot 官方推荐模板引擎。Thymeleaf是一种用于Web和独立环境的现代服务端的Java模板引擎。Thymeleaf能够处理HTML，XML，JavaScript，CSS甚至纯文本 

```xml
 <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-thymeleaf</artifactId>
 </dependency>
```

```xml
 <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
 </dependency>
```
2.FastJson 是一个JAVA编写的高性能JSON库
```xml
<dependency>
      <groupId>com.alibaba</groupId>
      <artifactId>fastjson</artifactId>
      <version>1.2.55</version>
</dependency>
```
3.okhttp 是轻量级的第三方网络访问框架。支持同步和异步请求。
```xml
<dependency>
      <groupId>com.squareup.okhttp3</groupId>
      <artifactId>okhttp</artifactId>
      <version>4.0.1</version>
</dependency>
```

4.数据库
    4.1.MyBatis-Spring-Boot-Starter 
        优势：建立独立的模块;减少代码量;减少XML的配置
        ```xml
         <dependency>
             <groupId>org.mybatis.spring.boot</groupId>
             <artifactId>mybatis-spring-boot-starter</artifactId>
             <version>2.1.0</version>
         </dependency>
        ```
    4.2 h2
        特别小;开源;内存数据库;浏览器独立应用程序
        ```xml
            <dependency>
                  <groupId>com.h2database</groupId>
                  <artifactId>h2</artifactId>
                  <version>1.4.199</version>
             </dependency>
        ```
    4.3 spring-boot-starter-data-jpa
        提供持久化的标准
        ```xml
         <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
         </dependency>
        ```
        

#### 资料

[前端框架 Bootstrap ](https://v3.bootcss.com)

#### 流程图

![[GitHub授权流程图](F:\IdeaProjects\blog\GitHub授权.PNG)](https://github.com/TequieroHan/blog/blob/master/GitHub授权.PNG)

```haml
https://github.com/login/oauth/authorize?登陆跳转到授权页面 
client_id=bbe5cbd333ddc89ed1cc&
redirect_uri=http://127.0.0.1:8081/callback/& 回调uri
scope=user& 返回 user信息
state=1
```

