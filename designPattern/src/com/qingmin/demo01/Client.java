package com.qingmin.demo01;

/**
 * @author code-yang
 * @date 2021/7/29 9:56
 * @Description
 * @Return
 * @Throws
 */
public class Client {
    public static void main(String[] args) {
        // 佛祖保佑，无 bug 运行
        IGoodBodyGirl girl = new PettyGirl("妈妈");
        AbstractSearcher searcher = new Searcher(girl);
        searcher.show();
    }
}
