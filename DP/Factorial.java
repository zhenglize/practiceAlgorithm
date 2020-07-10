package DP;
/**
*@author zhenglize
 动态规划就是优化版的递归
 使用动态规划，求n的阶乘的问题
*/
public class Factorial {
    public static long getFactorial(int n){
        if (n ==1){
            return 1L;
        }
        return (long)n*getFactorial(n-1);
    }

    public static void main(String[] args) {
        int n=5;
        System.out.println(getFactorial(n));
    }
}
