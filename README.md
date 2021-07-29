# spring_boot_demo
练习Springboot

#### SpringbootApplication same as  @SpringbootConfiguration @EnableAutoConfiguration @ComponentScan

#### @RestFullController same as @Controller + @ResponseBody



 proxyBeanMethods 代理bean的方法

  Full :proxyBeanMethods = true

  Lite :proxyBeanMethods = false

 应对组件依赖问题

#### 配置类 组件 之间没有依赖关系（一个bean中用了另一个bean）时，使用Lite模式，加速容器启动过程，减少判断

#### 配置类组件之间有依赖关系，方法会调用容器中的单实例组件，使用Full 模式

@Import({User.class, DBHelper.class})

Import 的参数是一个class类型的数组，里面可以导入任意的第三方组件，id默认是全类名，我们使用@Bean注册的组件和这个导入的组件不是同一个


@Conditional 条件装备

![img.png](img.png)


@ImportResource("classpath:/beans.xml")

ImportResource 用来导入 旧的 注册的大量bean

## 配置绑定的几种方式

### 自己定义： @Component + @ConfigurationProperties(prefix = "properties中对应类中的属性前缀")

###  @EnableConfigurationProperties(第三方类.class) + @ConfigurationProperties(prefix = "properties中对应类中的属性前缀")

1、开启Car配置绑定功能

2、把这个Car这个组件自动注册到容器中


