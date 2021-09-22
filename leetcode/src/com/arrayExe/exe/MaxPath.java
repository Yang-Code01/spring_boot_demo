package com.arrayExe.exe;

/**
 * @author code-yang
 * @date 2021/9/22 10:34
 * @Description
 * @Return
 * @Throws
 */
public class MaxPath {


    public int maxPathSum(int [][] a){
        int rows = a.length,cols = a[0].length;
        for (int i = 1; i < cols; i++) {
            a[0][i] += a[0][i-1];
        }
        for (int i = 1; i < rows; i++) {
            a[i][0] += a[i-1][0];
        }
        for (int i = 1; i < rows ; i++) {
            for (int j = 1; j < cols; j++) {
                a[i][j] = Math.max(a[i-1][j],a[i][j-1]);
            }
        }
        return a[rows-1][cols-1];

    }
}
