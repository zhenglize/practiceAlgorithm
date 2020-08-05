package search;
/**
*@author zhenglize
 差值查找算法和二分查找算法本质上是相同的，只是在计算mid的值的时候进行了优化
 他只要适用于连续的数组和分布比较均匀的数组
*/
public class InsertValueSearch {
    public static void main(String[] args) {
        int[] arr=new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i+1;
        }
        int index = insertValueSearch(arr, 0, arr.length - 1, 100);
        System.out.println("index="+index);
    }
    /**
      @param arr 待寻找的数组
      @param left 数组的左边界
      @param right 数组的右边界
     @param value 待查找的值
     */
    public static int insertValueSearch(int[] arr,int left ,int right,int value){
         //后边的两个条件必须加来放置越界
        if (left > right || value <arr[0] || value >arr[arr.length-1]){
            return -1;
        }
        //优化的mid的查找方式
        int mid=left+ (left+right) *(value - arr[left])/(arr[right]-arr[left]);
        if (arr[mid] > value){
           return  insertValueSearch(arr,left,mid-1,value);
        }else if (arr[mid] <value){
            return insertValueSearch(arr,mid+1,right,value);
        }else {
            return mid;
        }
    }
}
