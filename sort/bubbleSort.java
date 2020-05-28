package sort;
/**
*@author zhenglize
 * 冒泡排序:设计思想每次排好最大的那个，类似于冒泡一样，泡泡从大到小
*/
public class bubbleSort {
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
    *交换两个数组中索引元素位置的方法
    */
    public static void swap(int[] arr,int i,int j){
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
        bubbleSort(arr);
        //print 1 2 3 5 6 8 9
    }
}
