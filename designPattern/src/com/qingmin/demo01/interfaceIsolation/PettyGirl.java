package com.qingmin.demo01.interfaceIsolation;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author code-yang
 * @date 2021/7/29 9:48
 * @Description
 * @Return
 * @Throws
 */
@Data
@AllArgsConstructor
public class PettyGirl implements IGoodBodyGirl,IGreatTemperamentGirl{

    // name
    private String name;



    @Override
    public void goodLooking() {
        System.out.println("---goodLooking");
    }

    @Override
    public void niceFigure() {
        System.out.println("-----niceFigure");
    }

    @Override
    public void greatTemperament() {
        System.out.println("-----greatTemperament");
    }
}
