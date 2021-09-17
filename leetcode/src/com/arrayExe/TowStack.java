package com.arrayExe;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author code-yang
 * @date 2021/9/17 15:01
 * @Description
 * @Return
 * @Throws
 */
public class TowStack {
    // 使用双栈实现队列， stack1 存数据 ，当要pop 的时候，把 要pop的数据push到 stack2中

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public Integer pop(){
        if (stack2.isEmpty()){
            // 必须 stack1 中 有数据，有数据才能出
            while ( !stack1.isEmpty() ){
                stack2.push(stack1.pop());
            }
        }
       return stack2.pop();
    }

    public static void main(String[] args) {
        TowStack towStack = new TowStack();
        towStack.push(1);
        towStack.push(2);
        towStack.push(3);
        Integer pop = towStack.pop();
        Integer pop1 = towStack.pop();
        Integer pop2 = towStack.pop();
        System.out.println( pop + " " + pop1 + " " + pop2);
    }

    /*
     * public class TreeNode {
     *   int val = 0;
     *   TreeNode left = null;
     *   TreeNode right = null;
     * }
     */

    /**
     *
     * @param root TreeNode类
     * @return int整型ArrayList<ArrayList<>>
     */
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> listdAll = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        TreeNode tempLeft = root;
        TreeNode tempRight = root;

        while ( root != null ){
            list.add(root.val);
            listdAll.add(list);
            list.clear();
            if (tempLeft.left != null){
                root = tempLeft.left;
                list.add(root.val);
                tempLeft = root.left;
                if (tempLeft.right != null){
                    root = tempRight.right;
                    list.add(root.val);
                    tempRight = root.right;
                }
            }
            listdAll.add(list);
            list.clear();
        }
        return listdAll;
    }
}
