package com.qingmin.demo01.openAndclose;

/**
 * @author code-yang
 * @date 2021/7/30 17:10
 * @Description
 * @Return
 * @Throws
 */
// 打折书籍，不修改接口，不修改原来的类，采用继承的方式添加，覆写父类的getPrice方法
public class OffNovelBook extends NovelBook{
    public OffNovelBook(String name, String author, Integer price) {
        super(name, author, price);
    }

    @Override
    public int getPrice() {
        Integer selfPrice = super.getPrice(); // 原价
        Integer newPrice = 0;
        if (selfPrice > 4000){ // 原价大于40 打九折
            newPrice = selfPrice * 90 / 100;
        }else {
            newPrice = selfPrice * 80 / 100;
        }
        return newPrice;
    }
}
