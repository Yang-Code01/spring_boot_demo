package com.arrayExe;

import java.util.HashSet;

/**
 * @author code-yang
 * @date 2021/9/15 22:00
 * @Description
 * @Return
 * @Throws
 */
public class Main {

    // 快速排序
    public static void main(String[] args) {
        // 佛祖保佑，无 bug 运行
        int[] a = {1,12,4,34,12,545,2312,34,34,22,22,45,74};
        quickSort(a,0,a.length-1);
    }

    public static void quickSort(int[] arr, int start, int end){
        int i = start;
        int j = end;
        int standard = arr[start];
        if (i > j){
            return;
        }

        while (i <= j){
            while (standard < arr[j]){
                j--;
            }
            swap(arr,standard,arr[j]);
            while (standard > arr[i]){
                i++;
            }
            swap(arr,standard,arr[j]);

        }
        quickSort(arr,start,standard - 1);
        quickSort(arr,standard + 1,end);
    }
    // 交换
    public static void swap(int[] arr,int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
