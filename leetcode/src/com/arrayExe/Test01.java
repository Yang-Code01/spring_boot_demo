package com.arrayExe;

import java.util.Arrays;

/**
 * @author code-yang
 * @date 2021/8/2 16:58
 * @Description
 * @Return
 * @Throws
 */
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。

public class Test01 {
    class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length = nums1.length+nums2.length;
            int [] result = new int[length];
            for (int i = 0,j = 0; i < length;  i++) {
                if (i < nums1.length){
                    result[i] = nums1[i];
                }else {
                    result[i] = nums2[j];
                    j++;
                }
            }
            Arrays.sort(result);
            if(length % 2 != 0){
                return result[length / 2 ]/1.0;
            }
            return (result[length / 2 -1] + result[length /2]) / 2.0 ;
        }
    }
}
