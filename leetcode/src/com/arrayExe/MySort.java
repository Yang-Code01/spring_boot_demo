package com.arrayExe;

/**
 * @author code-yang
 * @date 2021/9/6 10:10
 * @Description
 * @Return
 * @Throws
 */
public class MySort {

    public static void quickSort(int[] arr,int left,int right) {
        if (left < right) {
            //只有当left < right的时候，排序才有意义
            int i = left;//辅助左指针
            int j = right;//辅助右
            int pivot = arr[i]; // 枢轴，将所有小于pivot的数放在它左边，所有大于pivot的数放在它右边
            while (i < j) {
                //当 i == j 时，循环才结束
                while (i < j && arr[j] >= pivot) {
                    //从后往前找，找到比pivot小的数，或者 i == j
                    j--;
                }
                if (i < j) {//如果退出上个循环后，i仍小于j，说明，找到了符合条件的数
                    arr[i] = arr[j];
                    //令i位置上的数等于j位置上的数
                    //由于交换数据太耗费时间，所以用这种方法代替
                    //最开始的i位置上的数已经通过pivot保存起来，此时为无效数据，可以用来保存j上的数据
                    //而赋值完成后，j上的数据为无效数据，在下一个循环中会被修改
                }
                while (i < j && arr[i] <= pivot) {
                    //此时再从前往后找，找到比pivot大的数，或者 i == j
                    i++;
                }
                if (i < j) {
                    //此时代表找到了这么个数，可以进行赋值
                    arr[j] = arr[i];
                }
            }
            //当循环退出后，i == j,此时i,j在同一位置，且为无效数据
            //修改该位置的数据为pivot，并利用递归完成其余两部分数据的排序
            arr[i] = pivot;
            //从中间位置往左
            quickSort(arr, left, i - 1);
            //从中间位置往右
            quickSort(arr, i + 1, right);
        }
    }

}
