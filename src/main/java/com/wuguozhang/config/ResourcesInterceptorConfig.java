package com.wuguozhang.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 作用：资源访问配置类
 *
 * @author wuguozhang
 * @version 1.0 2022.8
 */
@Configuration
public class ResourcesInterceptorConfig extends WebMvcConfigurationSupport {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        //文件磁盘图片url 映射
        //配置server虚拟路径，handler为前台访问的目录，locations为files相对应的本地路径
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("file:src/main/resources/static/data/");
        super.addResourceHandlers(registry);
    }



}
