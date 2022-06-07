package com.demo.springboot;

import org.springframework.context.annotation.DeferredImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

public class ImportSelect implements DeferredImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {

        //根据AutoConfiguration的名字去classpath寻找文件
        ServiceLoader<AutoConfiguration> loader = ServiceLoader.load(AutoConfiguration.class);

        List<String> list = new ArrayList<>();

        // 将文件中的路径名表示的类，当作配置类进行解析
        for (AutoConfiguration configuration : loader) {
            list.add(configuration.getClass().getName());
        }


        //返回  类名-配置
        return list.toArray(new String[0]);
    }
}
