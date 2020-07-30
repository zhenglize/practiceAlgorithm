package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
*@author zhenglize
 * 冒泡排序:设计思想每次排好最大的那个，类似于冒泡一样，泡泡从大到小
 * 时间复杂度为O（n^2），且与数据状况无关
*/
public class bubbleSort {
    //定义一个标记位，判断是否需要交换两个数字的顺序
    static boolean flag=false;
    public static void bubbleSort(int[] arr){
        //特殊情况进行判断
        if (arr == null || arr.length <2){
            return;
        }
        //每次排好最后一个位置的数，随后索引向前
        for(int end=arr.length-1 ; end >0 ;end--){
            for (int i = 0; i < end; i++) {
                //如果前一个数字大于后一个数字则交换位置
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
        print(arr);
    }
    /**
       bubbleSort的优化，声明一个标记为flag，当没有发生交换的时候，证明数组已经是有序的，
       退出循环
    */
    public static void bubbleSort02(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        for(int end=arr.length -1 ; end>=0 ; end--){
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
            //没有进行交换，代表剩下的数组已经有序，退出循环
            if (!flag){
                break;
            }else {
                flag=false;
            }
        }
   //     print(arr);
    }
    /**
    *交换两个数组中索引元素位置的方法
    */
    public static void swap(int[] arr,int i,int j){
        flag=true;
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    /**
    *打印数组中元素的方法
    */
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
    //测试方法
    public static void main(String[] args) {
        int[] arr={2,5,3,8,6,1,9};
        int[] temp=new int[80000];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = (int) (Math.random()*80000);
        }
        //排序前的时间为
        Date date=new Date();
        SimpleDateFormat simpleDateFormat=
                new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String data = simpleDateFormat.format(date);
        System.out.println("排序前的时间为:"+data);

    /*    bubbleSort(arr);
        System.out.println();
        System.out.println("优化的冒泡排序");*/
        //print 1 2 3 5 6 8 9
   //     int[] arr2={2,5,3,8,6,1,9};
        bubbleSort02(temp);
        System.out.println();
        Date date1=new Date();
        String data2 = simpleDateFormat.format(date1);
        System.out.println("排序完成的时间为:"+data2);
    }
}
