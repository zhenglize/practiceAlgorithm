package sort;
/**
*@author zhenglize
 * 插入排序
 * 设计思想类似于扑克牌，新来的那张牌与前一张最大的那张牌比较，如果小于则交换，之后接着向前比，直到小于前一张排为止
 * 举例说明
 * 数组 1 2 3 4 已经排好序了，新来了一个3小于4，4和3交换位置，接着3与3比较，不小于则本次插入操作终止 ,如果还可以插入
 * 则继续插入
 * 时间复杂度与数据状况有关，最好的情况时间复杂度为O(n)，最坏的情况时间复杂度为O（n^2）
*/
public class insertionSort {
    public static void insertionSort(int[] arr){
        //从数组中索引为1的位置开始插入排序操作
        for (int i = 1; i < arr.length; i++) {
            //这个for循环的意思是，若需要插入的元素，小于前一个的最大值，则进行交换操作
            for (int j = i-1; j >=0 && arr[j] >arr[j+1] ; j--) {
                swap(arr,j,j+1);
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
    public static void main(String[] args) {
        int[] arr={2,5,3,8,6,1,9,4};
        insertionSort(arr);
        //print 1 2 3 4 5 6 8 9
    }
}
