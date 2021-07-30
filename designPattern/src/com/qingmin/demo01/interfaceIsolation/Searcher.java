package com.qingmin.demo01.interfaceIsolation;

/**
 * @author code-yang
 * @date 2021/7/29 9:55
 * @Description
 * @Return
 * @Throws
 */
public class Searcher extends AbstractSearcher{

    public Searcher(IGoodBodyGirl pettyGirl) {
        super(pettyGirl);
    }

    @Override
    public void show() {
        System.out.println("-------信息如下");
        super.pettyGirl.goodLooking();
       // super.pettyGirl.greatTemperament();
        super.pettyGirl.niceFigure();
    }
}
