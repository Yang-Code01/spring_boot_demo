package com.qingmin.springbootdemo.converter;

import com.qingmin.springbootdemo.bean.Person;
import com.sun.deploy.util.DeployUIManager;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author code-yang
 * @date 2021/8/3 21:22
 * @Description  自定义的Converter 转换器
 * @Return
 * @Throws
 */

public class QingminConverter implements HttpMessageConverter<Person> {
    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return true;
    }

    /**
     * 服务器要统计所有的 MessageConvert 都能写出那些内容
     * @return
     */
    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return MediaType.parseMediaTypes("application/x-qingmin");
    }

    @Override
    public List<MediaType> getSupportedMediaTypes(Class<?> clazz) {
        return HttpMessageConverter.super.getSupportedMediaTypes(clazz);
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        // 自定义的协议数据写出
        String data = person.getUsername()+";"+person.getAge()+";"+person.getBirth();

        // 写出去
        OutputStream os = outputMessage.getBody();

        os.write(data.getBytes());

    }
}
