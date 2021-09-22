package com.arrayExe.exe;

import java.util.Scanner;

/**
 * @author code-yang
 * @date 2021/9/18 16:34
 * @Description
 * @Return
 * @Throws
 */

class dingdan {
    //订单号

    public Integer id;
    public Integer date_q;
    public Integer date_h;
}

public class Solo {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        //输入
        int N = in.nextInt();
        int date = in.nextInt();
        dingdan[] dd = new dingdan[N];
        for (int i = 0; i < N; i++) {
            dd[i] = new dingdan();
        }
        dd[0].id = in.nextInt();
        dd[0].date_q = in.nextInt();
        dd[0].date_h = in.nextInt();
        //直接使用插入排序
        for (int i = 1; i < N; i++) {
            dd[i].id = in.nextInt();
            dd[i].date_q = in.nextInt();
            dd[i].date_h = in.nextInt();


            //无序部分第一个值，即待插入值
            int value = dd[i].id;
            int valueq = dd[i].date_q;
            int valueh = dd[i].date_h;
            //有序部分最后一个值
            int yw = i - 1;
            //插入位置结束条件
            while (yw >= 0 && dd[yw].id > value) {

                //待插入值先前移动，有序部分向后移动
                dd[yw + 1].id = dd[yw].id;
                dd[yw + 1].date_q = dd[yw].date_q;
                dd[yw + 1].date_h = dd[yw].date_h;
                //让待插入值与有序部分倒数第（yw+） 比较
                yw--;
            }
            //待插入值插入,因为退出循环，说明位置找到（yw+1）
            dd[yw + 1].id = value;
            dd[yw + 1].date_q = valueq;
            dd[yw + 1].date_h = valueh;

        }


        boolean t = false;
        //按条件输出
        for (int i = 0; i < N; i++) {

            if (dd[i].date_q <= date && dd[i].date_h >= date) {
                System.out.println(dd[i].id);
                t = true;
            }
        }
        if (!t) {
            System.out.println("null");
        }


    }
}
