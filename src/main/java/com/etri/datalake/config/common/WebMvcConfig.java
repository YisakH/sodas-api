package com.etri.datalake.config.common;

import com.etri.datalake.auth.GetIdFromTokenArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    private final GetIdFromTokenArgumentResolver getIdFromTokenArgumentResolver;

    public WebMvcConfig(GetIdFromTokenArgumentResolver getIdFromTokenArgumentResolver) {
        this.getIdFromTokenArgumentResolver = getIdFromTokenArgumentResolver;
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers){
        resolvers.add(getIdFromTokenArgumentResolver);
    }

    @Override
    public void addCorsMappings(final CorsRegistry registry) {
        registry.addMapping("/**")
                //.allowedOrigins("/**")    //외부에서 들어오는 모둔 url 을 허용
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS") // GET, POST, PUT, PATCH, DELETE, OPTIONS 메서드를 허용한다.
                .allowedHeaders("*")    //허용되는 헤더
                .allowCredentials(true);    //자격증명 허용
    }
}
