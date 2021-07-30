package com.qingmin.demo01.openAndclose;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author code-yang
 * @date 2021/7/30 17:00
 * @Description
 * @Return
 * @Throws
 */
// 书店销售类
public class BookStore {
    private static final ArrayList<IBook> bookList = new ArrayList<>();
    private static final LinkedList<IBook> books = new LinkedList<>();
    // 简化，本应该是持久层实现
    static {
        bookList.add(new NovelBook("天龙八部","金庸",3200));
        bookList.add(new NovelBook("巴黎圣母院","雨果",5600));
        bookList.add(new NovelBook("金瓶梅","兰陵笑笑生",3422));

    }
    static {
        books.add(new OffNovelBook("天龙八部","金庸",3200));
        books.add(new OffNovelBook("巴黎圣母院","雨果",5600));
        books.add(new OffNovelBook("金瓶梅","兰陵笑笑生",3422));

    }


     //模拟书店买书

    public static void main(String[] args) {
        NumberFormat format = NumberFormat.getCurrencyInstance();
        format.setMaximumFractionDigits(2);
        System.out.println("----------书店销售记录-----------");
        System.out.println("原价");
        for (IBook book : bookList) {
            System.out.println("书籍名称："+book.getName()+"\t 书记作者："+book.getAuthor()
            +"\t 书记价格："+format.format(book.getPrice() / 100.0) + "元");
        }
        System.out.println();
        System.out.println("打折，40 以上九折，40一下八折");
        for (IBook book : books) {
            System.out.println("书籍名称："+book.getName()+"\t 书记作者："+book.getAuthor()
                    +"\t 书记价格："+format.format(book.getPrice() / 100.0) + "元");
        }

    }

}
