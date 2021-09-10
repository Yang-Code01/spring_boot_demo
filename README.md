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


## 面试相关

### CAS
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
### 锁

#### 自旋锁： 当一个线程获取锁的时候，另一个线程会再此获取时会一直循环获取，直到另一个线程释放锁，他才会获取到，不断的循环。
与互斥锁不同的是，互斥锁获取不到锁后，由 运行-->阻塞 ，而 自旋会 一直 运行-->(循环获取，直到获取到锁) 
```text
何谓自旋锁？它是为实现保护共享资源而提出一种锁机制。其实，自旋锁与互斥锁比较类似，它们都是为了解决对某项资源的互斥使用。
无论是互斥锁，还是自旋锁，在任何时刻，最多只能有一个保持者，也就说，在任何时刻最多只能有一个执行单元获得锁。
但是两者在调度机制上略有不同。对于互斥锁，如果资源已经被占用，资源申请者只能进入睡眠状态。
但是自旋锁不会引起调用者睡眠，如果自旋锁已经被别的执行单元保持，调用者就一直循环在那里看是否该自旋锁的保持者已经释放了锁，"自旋"一词就是因此而得名。
```

```text
跟互斥锁一样，一个执行单元要想访问被自旋锁保护的共享资源，必须先得到锁，
在访问完共享资源后，必须释放锁。如果在获取自旋锁时，没有任何执行单元保持该锁，那么将立即得到锁；
如果在获取自旋锁时锁已经有保持者，那么获取锁操作将自旋在那里，直到该自旋锁的保持者释放了锁。
由此我们可以看出，自旋锁是一种比较低级的保护数据结构或代码片段的原始方式，这种锁可能存在两个问题：
    死锁。
试图递归地获得自旋锁必然会引起死锁：递归程序的持有实例在第二个实例循环，以试图获得相同自旋锁时，不会释放此自旋锁。
在递归程序中使用自旋锁应遵守下列策略：递归程序决不能在持有自旋锁时调用它自己，也决不能在递归调用时试图获得相同的自旋锁。
    死循环
此外如果一个进程已经将资源锁定，那么，即使其它申请这个资源的进程不停地疯狂“自旋”,也无法获得资源，从而进入死循环。
过多占用cpu资源。如果不加限制，由于申请者一直在循环等待，因此自旋锁在锁定的时候,如果不成功,不会睡眠,会持续的尝试,
单cpu的时候自旋锁会让其它process动不了. 因此，一般自旋锁实现会有一个参数限定最多持续尝试次数. 
超出后, 自旋锁放弃当前time slice. 等下一次机会。
```

```text
由此可见，自旋锁比较适用于锁使用者保持锁时间比较短的情况。
正是由于自旋锁使用者一般保持锁时间非常短，因此选择自旋而不是睡眠是非常必要的，自旋锁的效率远高于互斥锁。
信号量和读写信号量适合于保持时间较长的情况，它们会导致调用者睡眠，因此只能在进程上下文使用，
而自旋锁适合于保持时间非常短的情况，它可以在任何上下文使用。如果被保护的共享资源只在进程上下文访问，
使用信号量保护该共享资源非常合适，如果对共享资源的访问时间非常短，
自旋锁也可以。但是如果被保护的共享资源需要在中断上下文访问（包括底半部即中断处理句柄和顶半部即软中断），
就必须使用自旋锁。自旋锁保持期间是抢占失效的，而信号量和读写信号量保持期间是可以被抢占的。
自旋锁只有在内核可抢占或SMP（多处理器）的情况下才真正需要，在单CPU且不可抢占的内核下，自旋锁的所有操作都是空操作。
```

```java
/**
 * @author code-yang
 * @date 2021/9/8 14:20
 * @Description 自旋锁（CAS原理）
 * @Return
 * @Throws 
 */
public class SpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void onLock(){
        System.out.println(Thread.currentThread().getName() +": onLock");
        // 当前线程
        Thread thread = Thread.currentThread();
        // 当前线程是否为null（解锁），为null 就跳出，否则 一直循环比较（CAS）
        while (! atomicReference.compareAndSet(null,thread)){

        }
    }

    public void unLock(){
        System.out.println(Thread.currentThread().getName() +": unLock");
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);

    }

    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();
        new Thread(() -> {
            // 上锁
            spinLock.onLock();
            // 暂停线程 保证 B 线程 进入自旋状态
            try { TimeUnit.SECONDS.sleep(5);}catch (Exception e) { e.printStackTrace();}
            // 解锁
            spinLock.unLock();
            // B 自旋完成
        },"AA").start();

        // 暂停线程,确保先执行A线程
        try { TimeUnit.SECONDS.sleep(3);}catch (Exception e) { e.printStackTrace();}


        new Thread(() -> {
           spinLock.onLock();
           spinLock.unLock();
        },"BB").start();
    }


}
```

#### 读写锁
ReentrantReadWriteLock

```java
package com.arrayExe.lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author code-yang
 * @date 2021/9/8 15:19
 * @Description 读写分离实验
 * @Return
 * @Throws
 */

class MyCache{
    // 保证写完之后，立即更新到主存中，使用volatile 保证可见性
    private volatile Map<String, Object> map = new HashMap<>();
    // 读写锁
    /**
     * 写的时候保证一个线程从头执行到尾，读的时候允许多个线程并发读
     */
    private ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();


    public void put(String key,Object value){
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() +":正在写入："+key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() +"：写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.writeLock().unlock();
        }
    }

    public void get(String key){
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() +":正在读取："+key );
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName() +":读取完成；");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            rwLock.readLock().unlock();
        }
    }


}

/**
 * @author AVTNTW672
 */
public class ReadWriteLock {

    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        for (int i = 0; i < 5; i++) {
            final int tempKey = i;
            new Thread(() -> {
                myCache.put(tempKey+"",tempKey+"");
            },String.valueOf(i)).start();
        }

        for (int i = 0; i < 5; i++) {
            final int tempKey = i;
            new Thread(() -> {
                myCache.get(tempKey+"");
            },String.valueOf(i)).start();
        }
    }


}

```

### CountDownLatch

```java
package com.arrayExe.lock.enumt;

import java.util.concurrent.CountDownLatch;

/**
 * @author code-yang
 * @date 2021/9/8 15:58
 * @Description 通过秦灭六国的例子模拟前提条件都完成才执行其他线程
 * @Return
 * @Throws
 */
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +"灭国");
                // 计数器每次执行一次就减一
                countDownLatch.countDown();
            },CountryEnum.forEach_CountryEnum(i).getGetRetValue()).start();
        }
        // 只有countDownLatch coutDown 完成后才通知
        countDownLatch.await();
        System.out.println("秦朝统一");

    }
}

```
### 枚举：
```java
package com.arrayExe.lock.enumt;

import lombok.Getter;

/**
 * @author code-yang
 * @date 2021/9/8 16:07
 * @Description 向 数据库中 的table 一样 定义数据
 * @Return
 * @Throws
 */
public enum CountryEnum {

    ONE(1,"齐国"),TWO(2,"楚国"),THREE(3,"韩国"),FOUR(4,"赵国"),FIVE(5,"魏国"),SIX(6,"燕国");

    CountryEnum(Integer getRetId, String getRetValue) {
        this.getRetId = getRetId;
        this.getRetValue = getRetValue;
    }

    @Getter private Integer getRetId; 
    @Getter private String getRetValue;

    /**
     * 通过索引拿数据
     */
    public static CountryEnum forEach_CountryEnum(int index){
        CountryEnum[] countryEnums = CountryEnum.values();
        for (CountryEnum countryEnum : countryEnums) {
            if (countryEnum.getRetId == index){
                return countryEnum;
            }
        }
        return null;
    }


}

```

###CyclicBarrier

```java
package com.arrayExe.lock.enumt;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author code-yang
 * @date 2021/9/8 17:25
 * @Description
 * @Return
 * @Throws
 */
public class CyclicBarrierDemo {

    public static void main(String[] args) {
        // CountDownLatch 做减法，CyclicBarrier 做加法
        // public CyclicBarrier(int parties, Runnable barrierAction)
        /**
         * 类似于 CountDownLatch 的反操作， 但是，这里的构造器就直接可以 写 前提任务完成后的任务，在前提任务每次执行一次后，只需要
         * 执行await 方法就行
         * 而 CountDownLatch 却没有这个构造器，而是先调用CountDown 方法，然后在最终执行的任务中调用await方法
         */
        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,() -> System.out.println("召唤神龙"));
        for (int i = 1; i <= 7 ; i++) {
            final int tempInt = i;
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() +"\t " +tempInt + "龙珠");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


    }
}

```


多个线程抢多个资源

### Semaphore:

```java
package com.arrayExe.lock.enumt;

import java.util.concurrent.Semaphore;

/**
 * @author code-yang
 * @date 2021/9/8 17:54
 * @Description
 * @Return
 * @Throws
 */
public class SemaphoreDemo {

    public static void main(String[] args) {

        /**
         * 多个线程抢多个资源
         */
        Semaphore semaphore = new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() +"线程：抢车位,stop");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                    System.out.println(Thread.currentThread().getName() +"线程：离开车位,start");
                }
            },String.valueOf(i)).start();
        }
    }
}

```


