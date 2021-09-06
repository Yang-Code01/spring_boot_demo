# spring_boot_demo
练习Springboot

#### SpringbootApplication same as  @SpringbootConfiguration @EnableAutoConfiguration @ComponentScan

#### @RestFullController same as @Controller + @ResponseBody



 - proxyBeanMethods 代理bean的方法

 - Full :proxyBeanMethods = true

 - Lite :proxyBeanMethods = false

 应对组件依赖问题

#### 配置类 组件 之间没有依赖关系（一个bean中用了另一个bean）时，使用Lite模式，加速容器启动过程，减少判断

#### 配置类组件之间有依赖关系，方法会调用容器中的单实例组件，使用Full 模式

- @Import({User.class, DBHelper.class})

- Import 的参数是一个class类型的数组，里面可以导入任意的第三方组件，id默认是全类名，我们使用@Bean注册的组件和这个导入的组件不是同一个


- @Conditional 条件装备

![img.png](img.png)


- @ImportResource("classpath:/beans.xml")

- ImportResource 用来导入 旧的 注册的大量bean

## 配置绑定的几种方式

##### 自己定义： @Component + @ConfigurationProperties(prefix = "properties中对应类中的属性前缀")

#####  @EnableConfigurationProperties(第三方类.class) + @ConfigurationProperties(prefix = "properties中对应类中的属性前缀")

1、开启Car配置绑定功能

2、把这个Car这个组件自动注册到容器中


## @EnableAutoConfiguration
里面：

@AutoConfigurationPackage  ： @Import({Registrar.class}) 给容器中导入一个组件
利用Register给容器中导入一系列组件  将指定的一个包下的所有组件都导入进来 主程序类所在包下（标注了@SpringBootApplication）

@Import({AutoConfigurationImportSelector.class})


### 按需开启自动配置

有100多个场景的所有自动配置启动的时候默认全部加载，
但是按条件装配规则，最终会按需配置


## Springboot 配置原理
```
1、Spring先加载所有的自动配置类 xxxAutoConfiguration

2、每个自动配置类按照条件进行生效，默认都会绑定配置文件指定的值，xxxProperties 里面拿， xxxProperties 和配置文件进行了绑定

3、生效的配置类就会给容器装配很对组件

4、只要容器中有这些组件,相当于这些功能就有了

5、定制化配置
    用户直接自己@Bean 替换掉底层的组件
    用户去看这个组件是获取的配置文件中的什么值，就可有定位去修改

流程： xxxAutoConfiguration ---> 组件  ---->  xxxProperties 


org.springframework.boot.autoconfigure 找到这个包，然后找到对应的自动配置类，再找注解



```

```html
 参照文档修改配置项

    自己分析，xxxProperties 绑定了配置文件的哪些

    自定义加入或替换组件 （@Bean @Component）

    自定义器 xxxCustomizer;


```

### 实践

引入场景依赖

查看自动配置了哪些

是否需要修改参数

    参照文档修改配置项

    自己分析，xxxProperties 绑定了配置文件的哪些

    自定义加入或替换组件 （@Bean @Component）

    自定义器 xxxCustomizer;


@Slf4j 来配置日志

<!--开启 yml 文件的提示-->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
<!--打包的时候排除开发阶段需要，部署的时候不需要的jar包-->
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                        <exclude>
                            <groupId>org.springframework.boot</groupId>
                            <artifactId>spring-boot-configuration-processor</artifactId>
                        </exclude>  


静态资源的访问：
源码：

private static final String[] CLASSPATH_RESOURCE_LOCATIONS = new String[]{"classpath:/META-INF/resources/", "classpath:/resources/", "classpath:/static/", "classpath:/public/"};


## dispatcherServlet 的分析（源码级别，日后探讨）：

    //    自定义 表单请求的 hiddenHttpMethod 请求参数过滤规则(针对于表单的自定义规则)
    @Bean
    public HiddenHttpMethodFilter httpMethodFilter(){
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        filter.setMethodParam("_m");
        return filter;
    }



@PathVariable : 底层定义了一个 Map<String,String> ，用来存储路径上的参数

PathVariable,RequestHeader:springboot 底层都有一个kv均为String类型的Map，
@RequestHeader Map<String,String> header， 可以使用默认的map 来获取all参数

@PathVariable Map<String,String> pv,

@RequestParam() Map<String,String> params

@RequestBody 是一个将请求体整合成一个String类型，而不是和其他一样可以指定kv来获取


@PathVariable、@RequestHeader、@ModelAttribute、@RequestParam、@MatrixVariable、@CookieValue、@RequestBody




MatrixVariable 的使用，实现webMvcConfigurer接口，或者：

     @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                // 不移除分号后面的内容,使矩阵变量生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }
        };
    }


### 内容协商（导入jkson-xml）
根据客户端的接受能力的不同，返回不同媒体类型的数据

1、判断当前响应头中是否已经有确定的媒体类型  MediaType

2、获取客户端（PostMan、浏览器）支持接收的内容类型。（获取客户端Accept请求头字段）

3、遍历循环所有当前系统的MessageConverter，看谁支持操作这个对象

4、找到支持操作的对象类的Converter，把converter支持的媒体类型统计出来
5、客户端需要【application/xml】 服务端能力【10种，json、xml。。】

##

    /**
     * 1、浏览器发请求直接返回xml  【application/xml】    jacksonXmlConverter
     * 2、如果使ajax 请求，返回  json   【application/json】  jasksonJsonConverter
     * 2、如果是app 发请求，返回自定义协议数据， 【application/x-qingmin】    xxxQingMinConverter
     *  属性值1；属性值2
     * 步骤：
     * 1、添加自定义的MessageConverter 到 系统底层
     * 2、系统底层就会统计出所有MessageConverter能操作那些类型
     * 3、客户端内容协调【qingMin --->  QingMIi】
     * 实现：
     * 1、实现HttpMessageConverter 这个接口，实现所有方法，canWrite()设置为true ，getSupportedMediaTypes（）'
     * 加入自定义的转换MediaType,write()通过这个方法写出数据
     * 2、需要再我们的Webconfier中配置extendMessageConverters（）
     *
     * @return
     */

####  以参数的方式进行内容协商



## 视图解析与模板引擎

1、视图解析

处理方式： 转发、重定向、自定义视图




CAS
中的ABA问题

- 什么是ABA问题： 多个线程操作原子类，当线程1和线程2同时操作，线程2在线程1还没有执行到比较和交换之前，已经执行了修改多次操作，并且，
在执行完成后将数据该回，导致当线程1cas时，发现期望数据是一致的，会执行修改
  
    - 1线程  copy A  -- 执行--- 
    - 2线程  copy A  -- 执行--  CAS --- 修改为 B --- CAS，修改完成，再次 copy ， 修改 为 A  CAS 修改完成
    - 1线程 CAS 发现 期望数据是A， 执行
    
    在此过程中， 线程1的CAS 只能保证 开头和结尾的数据一致性， 中间可能被修改，无法顾及

-- 原子引用 

```java
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        User zs = new User("zs", 11);
        User ls = new User("ls",13);

        AtomicReference<User> userAtomicReference = new AtomicReference<>();

        userAtomicReference.set(zs);
        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get());
        System.out.println(userAtomicReference.compareAndSet(zs, ls)+"\t"+userAtomicReference.get());


    }
}

```
如何解决 ABA问题？ 时间戳原子引用

```java
package com.arrayExe.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author code-yang
 * @date 2021/9/6 16:21
 * @Description
 * @Return
 * @Throws
 */
public class ABADemo {
    
    public static AtomicReference atomicReference = new AtomicReference(100);

    public static AtomicStampedReference stampedReference = new AtomicStampedReference(100,1);


    public static void main(String[] args) {
        System.out.println("---ABA问题----");
        new Thread(() -> {
            // 线程一先执行完成
            System.out.println("t1 f:"+atomicReference.compareAndSet(100, 101)+"当前值："+atomicReference.get());
            System.out.println("t1 s:"+atomicReference.compareAndSet(101, 100)+"当前值："+atomicReference.get());
        },"t1").start();
        
        new Thread(() -> {
            // 暂停线程
            try { TimeUnit.SECONDS.sleep(1);}catch (Exception e) { e.printStackTrace();}

            boolean b = atomicReference.compareAndSet(100, 300);
            System.out.println("t2:"+b+"\t"+"当前值："+atomicReference.get());


        },"t2").start();
        
        // 暂停线程
        try { TimeUnit.SECONDS.sleep(3);}catch (Exception e) { e.printStackTrace();}
        

        System.out.println("----ABA问题的解决----");


        new Thread(() -> {
            System.out.println("t3线程开始");
            // 戳
            int stamp = stampedReference.getStamp();
            // 戳 --1 --》2 --》3
            System.out.println("初始戳："+stamp);
            stampedReference.compareAndSet(100,101,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println("stampedReference.getStamp() = " + stampedReference.getStamp());
            stampedReference.compareAndSet(101,100,stampedReference.getStamp(),stampedReference.getStamp()+1);
            System.out.println("stampedReference.getStamp() = " + stampedReference.getStamp());
            System.out.println("t3线程结束");
        },"t3").start();

        new Thread(() -> {
            System.out.println("t4线程开始");
            // 暂停线程
            try { TimeUnit.SECONDS.sleep(5);}catch (Exception e) { e.printStackTrace();}

            int stamp = stampedReference.getStamp();
            System.out.println("戳："+stamp);
            // 预期值一样，但戳不一样
            boolean result = stampedReference.compareAndSet(100,200,1,2);
            System.out.println("result = " + result);
            System.out.println("当前戳：" + stampedReference.getStamp());

            System.out.println("t4线程结束");
        },"t4").start();
    }
}

```

