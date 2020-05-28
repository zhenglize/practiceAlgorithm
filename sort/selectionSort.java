package sort;
/**
*@author zhenglize
 * 选择排序
 * 每次找到最小的数的索引，之后交换索引元素的位置
*/
public class selectionSort {
    public static void selectionSort(int[] arr){
        if (arr == null || arr.length<2)
            return;
        /**
        *外面的for循环的意思是每次找到最小索引位置的数,直到数组的长度
         * 0~N-1 1~N-1
        */
        for (int i = 0; i < arr.length; i++) {
            //记录最小位置索引的变量
            int minIndex=i;
            //从i+1的索引位置向下找小于minIndex索引位置的元素
            for (int j = i+1; j < arr.length; j++) {
                //找到最小位置的值
                minIndex=arr[minIndex] < arr[j] ? minIndex : j;
            }
            swap(arr,i,minIndex);
        }
        //打印数组中元素
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
    public static void main(String[] args) {
        int[] arr={2,5,3,8,6,1,9,4};
         selectionSort(arr);
        //print 1 2 3 4 5 6 8 9
    }
}
