package com.qingmin.demo01.interfaceIsolation;

import lombok.AllArgsConstructor;

/**
 * @author code-yang
 * @date 2021/7/29 9:51
 * @Description
 * @Return
 * @Throws
 */
@AllArgsConstructor
public abstract class AbstractSearcher {

    protected IGoodBodyGirl pettyGirl;

    public abstract void show();

}
