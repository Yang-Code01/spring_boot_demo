package com.arrayExe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author code-yang
 * @date 2021/9/17 10:56
 * @Description
 * @Return
 * @Throws
 */
public class TreeNode {

    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
}

class Solution{
    public static void main(String[] args) {
        threeOrders(new TreeNode());
    }

    public static int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] array = new int[3][];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        List<Integer> list3 = new ArrayList<>();
        preOrder(root,list1);
        inOrder(root,list2);
        postOrder(root,list3);
        array[0] = new int[list1.size()];
        array[1] = new int[list2.size()];
        array[2] = new int[list3.size()];

        for (int i = 0; i < list1.size(); i++) {
            array[0][i] = list1.get(i);
            array[1][i] = list2.get(i);
            array[2][i] = list3.get(i);
        }

        return array;
    }


    public static void preOrder(TreeNode root, List<Integer> list){
        if (root != null) {
            list.add(root.val);
            preOrder(root.left,list);
            preOrder(root.right,list);
        }
    }
    public static void inOrder(TreeNode root, List<Integer> list){
        if (root != null) {
            inOrder(root.left,list);
            list.add(root.val);
            inOrder(root.right,list);
        }
    }
    public static void postOrder(TreeNode root, List<Integer> list){
        if (root != null) {
            postOrder(root.left,list);
            postOrder(root.right,list);
            list.add(root.val);

        }
    }

}
 class Solution1 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        // 排序
        Arrays.sort(input);
        ArrayList  <Integer> list = new ArrayList<>();
        // 取值
        for (int i = 0; i < k; i++){
            list.add(input[i]);
        }
        return list;
    }
}