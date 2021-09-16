package com.arrayExe;

import java.util.Arrays;

/**
 * @author code-yang
 * @date 2021/9/15 17:53
 * @Description
 * @Return
 * @Throws
 */
public class Main {
    public static void main(String[] args) {
        int [] a = {4,7,3,1,5,6,8,10};
        quickSort(a,0,a.length-1);
        for (int i : a) {
            System.out.print(i);
        }
    }

    public static void quickSort(int[] arr, int start, int end){
        if (start >= end) {
            return;
        }
        int standard = arr[start];
        int i = start;
        int j = end;
        while (i < j) {
            while (j > i && arr[j] > standard) {
                j--;
            }
            while (i < j && arr[i] <= standard) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, i, start);

        quickSort(arr, start, i - 1);
        quickSort(arr, i + 1, end);
    }


    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
