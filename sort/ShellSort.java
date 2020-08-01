package sort;

import java.util.Arrays;

/**
*@author zhenglize
 希尔排序:设计思想，利用数组的长度不断的/2直到为1，静分成的两个部分进行插入排序
*/
public class ShellSort {
    public static void main(String[] args) {
        int[] arr={8,9,1,7,2,3,5,4,6,0};
      //  shellSort(arr);
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));
    }
  public static void shellSort(int[] arr){
        int gap=arr.length;
        while (gap !=1){
            //gap是每一步的步长
            gap=gap/2;
            //外层循环从步长开始
            for (int i = gap; i < arr.length; i++) {
                //表示从第一个位置进行插入排序，每次加步长个单位
                for (int j = i-gap; j >=0 ; j-=gap) {
                    //进行插入排序
                    if (arr[j] > arr[j+gap]){
                        swap(arr,j,j+gap);
                    }
                }
            }
        }
  }
  //采用移位法优化速度
    public static void shellSort2(int[] arr){
        //不断的缩小gap的值
        for (int gap = arr.length /2; gap >0 ; gap=gap/2) {
           //从gap开始进行移位操作
            for (int i = gap; i < arr.length; i++) {
                int j=i;
                int temp=arr[j];
                if (arr[j] < arr[j-gap] ){
                    //进行移位操作
                    while (j-gap >=0 && arr[j-gap] > temp){
                        arr[j] =arr[j-gap];
                        j-=gap;
                    }
                    //退出while循环代表找到了temp的位置
                    arr[j] =temp;
                }
            }
        }
    }
    public static void swap(int[] arr, int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
