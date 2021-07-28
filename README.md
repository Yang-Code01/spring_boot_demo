# spring_boot_demo
练习Springboot

###SpringbootApplication same as  @SpringbootConfiguration @EnableAutoConfiguration @ComponentScan

####@RestFullController same as @Controller + @ResponseBody



 proxyBeanMethods 代理bean的方法

  Full :proxyBeanMethods = true

  Lite :proxyBeanMethods = false

 应对组件依赖问题

####配置类 组件 之间没有依赖关系（一个bean中用了另一个bean）时，使用Lite模式，加速容器启动过程，减少判断

####配置类组件之间有依赖关系，方法会调用容器中的单实例组件，使用Full 模式