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
