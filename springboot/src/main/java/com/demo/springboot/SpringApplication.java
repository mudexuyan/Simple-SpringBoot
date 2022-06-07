package com.demo.springboot;


import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;


import java.util.Map;

public class SpringApplication {
    public static void run(Class clazz) {
        //创建spring 容器
        AnnotationConfigWebApplicationContext ApplicationContext = new AnnotationConfigWebApplicationContext();
        //注册配置类，@configuration所在的类。@componentScan扫描配置类所在的目录下的所有的bean
        ApplicationContext.register(clazz);
        ApplicationContext.refresh();

        //启动 tomcat
//        startTomcat(ApplicationContext);


        // tomcat jetty undertow统称为webServer
        WebServer webServer = getWbeServer(ApplicationContext);
        webServer.start();
    }

    public static WebServer getWbeServer(WebApplicationContext applicationContext) {

        //获得webServer的bean
        Map<String, WebServer> beansOfType = applicationContext.getBeansOfType(WebServer.class);

        if (beansOfType.isEmpty()) {
            throw new NullPointerException();
        }

        //如果有多个，返回第一个
        return beansOfType.values().stream().findFirst().get();

    }


}
