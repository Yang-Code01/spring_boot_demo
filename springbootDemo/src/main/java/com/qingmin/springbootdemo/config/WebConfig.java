package com.qingmin.springbootdemo.config;

import com.qingmin.springbootdemo.bean.Pet;
import com.qingmin.springbootdemo.converter.QingminConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author code-yang
 * @date 2021/7/31 22:50
 * @Description
 * @Return
 * @Throws
 */
@Configuration(proxyBeanMethods = false)
public class WebConfig {

//    自定义 表单请求的 hiddenHttpMethod 请求参数过滤规则
    @Bean
    public HiddenHttpMethodFilter httpMethodFilter(){
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        filter.setMethodParam("_m");
        return filter;
    }

    /**
     *自定义的 MediaType
     */
    private static final String APPLICATION_QINGMIN = "application/x-qingmin";
    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        return new WebMvcConfigurer() {

            /*@Override
            public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
                Map<String,MediaType> map = new HashMap<>();
                map.put("json",MediaType.APPLICATION_JSON);
                map.put("xml",MediaType.APPLICATION_ATOM_XML);
                map.put("json",MediaType.parseMediaType(APPLICATION_QINGMIN));
                configurer.mediaTypes(map);
            }*/

            // 把自定义的者转换规则配置到Spring配置中
            @Override
            public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
                converters.add(new QingminConverter());
            }

            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 不移除分号后面的内容,使矩阵变量生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

           /* @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter((String source) ->{
                    if (source != null || "".equals(source)){
                        Pet pet = new Pet();
                        String[] split = source.split(",");
                        pet.setName(split[0]);
                        pet.setAge(Integer.parseInt(split[1]));
                        return pet;
                    }
                   return null;
                });
            }*/

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet>() {

                    @Override
                    public Pet convert(String source) {
                        if (source != null || "".equals(source)){
                            Pet pet = new Pet();
                            String[] split = source.split(",");
                            pet.setName(split[0]);
                            pet.setAge(Integer.parseInt(split[1]));
                            return pet;
                        }
                        return null;
                    }
                });
            }


        };
    }
}
