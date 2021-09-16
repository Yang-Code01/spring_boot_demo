import java.nio.charset.Charset;
import java.util.*;

/**
 * @author code-yang
 * @date 2021/9/15 10:48
 * @Description
 * @Return
 * @Throws
 */
public class Secure {

    public static void main(String[] args) {
       /* // N: 位数， M: 轮数
        int N,M;
        // 读取
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        int number[] = new int[M *2];
        for (int i = 0; i < number.length ; i++) {
            number[i] = scanner.nextInt();
        }
        // 加密
        int password = method(number,N,M);
        System.out.println(password);*/


        Scanner scanner = new Scanner(System.in);
        String str  = scanner.nextLine();

        boolean result = methodString(str);
        if (result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }

    public static boolean methodString(String str){

        // 转成char型数组
        char[] chars = str.toCharArray();
        int countLeft = 0;
        int countRight = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '('){
                countLeft++;
            }else if (chars[i] == ')'){
                countRight++;
            }else {
                return false;
            }
        }
        return countLeft == countRight ? true : false;
    }



    // 根据第几轮来设置值
    public static int method(int num [],int n,int m){
       int[] newArray = new int[n];
       int password = 0;
        // i 控制轮数，j控制数据, 设置值
        for (int i = 1,j = 0; i <= m ; i++,j++) {
            int Na = num[j];
            int Nb = num[++j];
            newArray[Na] = i;
            newArray[Nb] = i;
        }
        for (int i = 0; i < newArray.length; i++) {
            password += i * newArray[i];
        }

        return password % 100000009;
    }
}


 class Solution {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     *
     * @param s string字符串
     * @return string字符串
     */
    public static String unique_string (String s) {
        // write code here
        //Set<Character> set = new HashSet<>();
        //StringBuffer sb = new StringBuffer();
        //char[] chars = s.toCharArray();
        //for (char c : chars) {
        //    if (!set.contains(c)){
        //        set.add(c);
        //        sb.append(c);
        //    }
        //
        //}
        //return sb.toString();

        StringBuffer stringBuffer = new StringBuffer();
        // 当前字符的索引是否为 该字符第一次出现的位置上的索引
        for (int i = 0; i < s.length(); i++) {
            if (s.indexOf(s.charAt(i)) == i){
                stringBuffer.append(s.indexOf(i));
            }
        }
        return stringBuffer.toString();
    }

     public static void main(String[] args) {
         String result = unique_string("abcdaacesfFF");
         System.out.println( result);
         String a = "absdf";
         System.out.println(a);

     }
    // 快排

     public static void sort(int[] a,int low,int high){
        int start = low;
        int end = high;
        // 基准值
        int key = a[low];
        while (end > start){
            // 从后往前比较
            while (end > start && a[end] >= key){
                // 从后面开始遍历，找到比 基准值小的
                end--;
                if (a[end] <= key){
                    int temp = a[end];
                    a[end] = a[start];
                    a[start] = temp;

                }
            }
        }
     }


}