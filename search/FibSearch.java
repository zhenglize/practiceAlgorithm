package search;

import java.util.Arrays;

/**
*@author zhenglize
 斐波那契查找
*/
public class FibSearch {
    public static void main(String[] args) {
        int[] arr={1,3,56,754,8969};
        System.out.println(fibSearch(arr, 56));
    }
   //产生斐波那契的数组的长度
   static int maxSize=20;
    public static int[] fib(){
        int[] f=new int[maxSize];
        //斐波那契数列的前两个位置的元素为1，后面的位置是前两个数字的和
        f[0]=1;
        f[1]=1;
        for (int i = 2; i < maxSize; i++) {
            f[i] =f[i-2]+f[i-1];
        }
        return f;
    }
    /**
      @param arr 待查找的数组
     @param val 待查找的值
    */
    public static int fibSearch(int[] arr,int val){
        //数组的左右边界
        int low=0;
        int high=arr.length-1;
        //产生的斐波那契数列
        int[] fib=fib();
        //中间值mid
        int mid=0;
        //斐波那契分割点
        int k=0;
        while (high >fib[k] -1){
            k++;
        }
        //因为k的长度可能大于arr数组，所以要重新创建一个数组，后面的值用最大值补齐
        int[] temp= Arrays.copyOf(arr,k);
        for (int i = high+1; i < k; i++) {
            temp[i]=arr[high];
        }
        //寻找值
        while (low <=high){
            mid=low+fib[k-1]-1;
            //向左寻找
            if (temp[mid] > val){
                //f[k-1] =f[k-2]+f[k-3]
                high=mid-1;
                k--;
            }else if (temp[mid] <val){
                //f[k-2]=f[k-3]+f[k-4]
                low=mid+1;
                k-=2;
            }else {
                if (high >=mid){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        return -1;
    }
}
