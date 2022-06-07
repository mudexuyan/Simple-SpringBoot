# Simple-SpringBoot
手写简化版spring boot
具体解析，https://www.yuque.com/wuangwang-lkix6/mm8e17/zh5kn7/edit#wYgKX

# 简介
1. 实现了自动配置功能
2. 定义com.demo.springboot.AutoConfiguration文件，只需要在文件中添加AutoConfiguration的路径，即可引入不同模块中，该配置类所在目录下的bean
3. 实现DeferredImportSelector接口，定义ImportSelec，在springboot注解上定义@Import(ImportSelect.class)，从而实现自动配置功能
4. 自定义condition注解

# 使用，通过自定义condition注解实现。
1. 通过修改user的pom文件，启动Jetty服务器
```
<dependency>
            <groupId>com.demo</groupId>
            <artifactId>springboot</artifactId>
            <version>1.0-SNAPSHOT</version>
            <exclusions>
                <exclusion>
                    <groupId>org.apache.tomcat.embed</groupId>
                    <artifactId>tomcat-embed-core</artifactId>
                </exclusion>
            </exclusions>
</dependency>

<dependency>
            <groupId>org.eclipse.jetty</groupId>
            <artifactId>jetty-server</artifactId>
            <version>9.4.43.v20210629</version>
</dependency>
```
2. 通过修改user的pom文件，启动Tomcat服务器
```
<dependency>
  <groupId>com.demo</groupId>
  <artifactId>springboot</artifactId>
  <version>1.0-SNAPSHOT</version>
</dependency>

        
```



