package sort;
/**
*@author zhenglize
 * 桶排序、计数排序、基数排序的介绍
 * 1，非基于比较的排序，与被排序的样本的实际数据状况很有关系，所以实际中并不经常使用
 * 2，时间复杂度O(N)，额外空间复杂度O(N)
 * 3，稳定的排序
 * 三个for循环
 * 第一个for循环找到创建桶的范围
 * 第二个for循环将值拷贝至桶中
 * 第三个for循环进行排序操作
 *
*/
public class bucketSort {
    public static void bucketSort(int[] arr){
        //找出需要桶的个数
        int max= Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
        }
        //创建桶
        int[] bucket=new int[max+1];
        //将arr中的数据放到桶中
        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }
        //取出桶中的数据排好序
        int j=0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- >0){
                arr[j++] =i;
            }
        }
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
        int[] arr={3,5,21,3,4,7,81,3,4,1};
        bucketSort(arr);
        print(arr); //print 1 3 3 3 4 4 5 7 21 81
    }
}
