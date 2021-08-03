package com.qingmin.demo01.product.demo1;

/**
 * @author code-yang
 * @date 2021/8/3 10:46
 * @Description
 * @Return
 * @Throws
 */
public class HumanFactory extends AbstractHumanFactory{
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        // 定义一个生产人中
        Human human = null;
        // 生产一个人种
        try {
            human = (T) Class.forName(c.getName()).newInstance();
        }catch (Exception e) {
            System.out.println("人种生成错误");
        }
        return (T) human;
    }
}
