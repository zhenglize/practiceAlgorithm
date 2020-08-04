package search;
/**
*@author zhenglize
  线性查找
*/
public class SeqSearch {
    public static void main(String[] args) {
        int[] arr={5,12,45,-1,232,43};
        int index = seqSearch(arr, 45);
        if (index == -1){
            System.out.println("没有找到");
        }else {
            System.out.println("数组的索引为:"+index);
        }
    }
    /**
      @param arr 待寻找的数组
      @param value  待寻找的值
    */
    public static int seqSearch(int[] arr ,int value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] ==value){
                return i;
            }
        }
        return -1;
    }
}
