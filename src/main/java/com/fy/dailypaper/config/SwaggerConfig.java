package com.fy.dailypaper.config;


import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration //配置 目的：让@Bean生效
@EnableSwagger2 //让swagger生效
public class SwaggerConfig {
    //1.创建api信息
    public ApiInfo createInfo(){
        return new ApiInfoBuilder().title("接口文档名称").description("接口文档的描述信息")
                .contact(new Contact("Flying","https://www.baidu.com","ssss@163.com"))
                .build();
    }
    //2.创建Swagger需要的对象 包含api信息 和生效内容
    @Bean
    public Docket createSwagger(){
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(createInfo()).select().
                apis(RequestHandlerSelectors.withClassAnnotation(Api.class)).build();
    }

}
