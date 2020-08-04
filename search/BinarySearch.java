package search;

import java.util.ArrayList;
import java.util.List;

/**
*@author zhenglize
  二分查找:针对有序数组的
*/
public class BinarySearch {
    public static void main(String[] args) {
        int[] arr={1,8,10,100,100,100,100,1314};
       /* int index = binarySearch(arr, 0, arr.length - 1, 100);
        if (index==-1){
            System.out.println("没有找到");
        }else {
            System.out.println("数组的索引为:"+index);
        }*/
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 100);
        System.out.println("寻找到的数组索引为:"+list);
    }
    /**
      @param arr 待查找的数组
     @param left 数组的左边界
     @param right 数组的右边界
     @param value 待查找的值
    */
    public static int binarySearch(int[] arr, int left,int right ,int value){
      //如果找不到返回-1
       if (left > right){
           return -1;
       }
       int mid=(left + right)/2;
       if (arr[mid] > value){
           return binarySearch(arr,left,mid-1,value);
       }else if (arr[mid] <value){
           return binarySearch(arr,mid+1,right,value);
       }else {
           return mid;
       }
  }
  //拓展功能返回数组中相等值的集合
  public static List<Integer> binarySearch2(int[] arr, int left, int right , int value){
      //如果找不到返回-1
      if (left > right){
          return new ArrayList<>();
      }
      int mid=(left + right)/2;
      if (arr[mid] > value){
          return binarySearch2(arr,left,mid-1,value);
      }else if (arr[mid] <value){
          return binarySearch2(arr,mid+1,right,value);
      }else {
          List<Integer> list=new ArrayList<>();
          //向左寻找，看看有没有和mid值相同的
          int temp=mid-1;
          while (true){
              if (temp <0 || arr[temp] !=value){
                  break;
              }
              list.add(temp);
              temp--;
          }
          list.add(mid);
          //向右寻找
          temp=mid+1;
          while (true){
              if (temp > arr.length-1 || arr[temp] !=value){
                  break;
              }
              list.add(temp);
              temp++;
          }
          return list;
      }
  }
}
