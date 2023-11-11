package com.psh.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer  {

    @Value("${file.upload}")
    private String basePath;

    @Value("${file.resourcePrefix}")
    String resourcePrefix;


    /**
     * 自定义资源映射
     * file:表示本地绝对目录
     * 可以看出访问的是： http://localhost:8080/mhh/interceptor/document/aa.png
     *                http://192.168.10.105:8000/api/uploadFile/4.png
     *                映射的是:   H:/upload/
     *                H:/upload/1.png
     *                file:///H:/upload/4.png
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 添加静态资源路径，然后跟项目的路径进行映射
        //file:表示本地绝对目录

        registry.addResourceHandler(resourcePrefix+"/**").addResourceLocations("file:///"+basePath);

        //addResourceHandler为添加映射路径。
        //addResourceLocations为添加资源路径。
        //classpath:表示项目绝对目录
//        registry.addResourceHandler("/mhh/interceptor/js/*").addResourceLocations("classpath:static/js/");
    }




}
