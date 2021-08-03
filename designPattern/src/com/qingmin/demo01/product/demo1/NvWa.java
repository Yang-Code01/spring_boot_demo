package com.qingmin.demo01.product.demo1;

/**
 * @author code-yang
 * @date 2021/8/3 10:49
 * @Description
 * @Return
 * @Throws
 */
public class NvWa {
    public static void main(String[] args) {
        // 佛祖保佑，无 bug 运行
        AbstractHumanFactory humanFactory = new HumanFactory();
        System.out.println("生产黄种人");
//        Human yellowMan = new YellowHuman();
        Human yellowHuman = humanFactory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();

        System.out.println("生产白人");
        Human whiteHuman = humanFactory.createHuman(WhiteHuman.class);
        whiteHuman.getColor();
        whiteHuman.talk();

        System.out.println("生产黑人");
        Human blackHuman = humanFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();

    }


}
