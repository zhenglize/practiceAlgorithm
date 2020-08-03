package sort;

import java.util.Arrays;

/**
*@author zhenglize
 基数排序
*/
public class RadixSort {
    public static void main(String[] args) {
        int[] arr={5,45,12,454,34,18,59,33};
        radixSort(arr);
        System.out.println(Arrays.toString(arr));
    }
   public static void radixSort(int[] arr){
       if (arr == null || arr.length <2){
           return;
       }
       //1.求出数组的最大值的位数
       int max=arr[0];
       for (int i = 1; i < arr.length; i++) {
           if (arr[i] > max){
               max=arr[i];
           }
       }
       //记录最大的位数
       max=(max+"").length();
       //声明桶,二维数组，前一个是桶的编号，后一个是桶的大小
       int[][] bucket=new int[10][arr.length];
       //声明一个一维数组记录桶中的元素个数
       int []  bucketCounts=new int[10];
       //将数组中的元素添加到桶中
       for (int i = 0 , n=1; i < max; i++,n=n*10) {
           for (int j = 0; j < arr.length; j++) {
               //取出当前数字对应的个位，十位，百位数
               int digit=arr[j] / n % 10;
               //将对应位置的值添加到桶中
               bucket[digit][bucketCounts[digit]]=arr[j];
               bucketCounts[digit]++;
           }
           int index=0;
           //从桶中取出元素，并将其重新复制到数组中
           for (int k = 0; k < bucketCounts.length; k++) {
               if (bucketCounts[k] !=0){
                   for (int j = 0; j < bucketCounts[k]; j++) {
                       //给数组中的元素重新赋值
                       arr[index++]=bucket[k][j];
                   }
               }
               //给bucketCount置空，便于下一轮的使用
               bucketCounts[k]=0;
           }
       }
   }
}
