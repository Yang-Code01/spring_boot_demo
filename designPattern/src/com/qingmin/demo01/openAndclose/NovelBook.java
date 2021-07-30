package com.qingmin.demo01.openAndclose;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author code-yang
 * @date 2021/7/30 16:56
 * @Description
 * @Return
 * @Throws
 */
@AllArgsConstructor
public class NovelBook implements IBook{
    // bookName
    private String name;

    // author
    private String author;

    // price  价格一般保留两位，我们使用int类型扩大100倍，需要的是时候再缩小100倍，减少精度带来的误差
    private Integer price;

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getPrice() {
        return this.price;
    }

    @Override
    public String getAuthor() {
        return this.author;
    }
}
