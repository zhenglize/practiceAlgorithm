package sort;
/**
*@author zhenglize
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，
 * 大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 * 解题思路:
 * 使用三个变量，左边界为L-1位置，右边界为R+1位置，和当前指针cur变量，若cur小于给定的值num，则交换当前数字和
 * 左边界的那个位置，左边界++，cur++。若大于则交换右边界和当前cur的值，此时cur不变继续比较交换的那个值的大小
 * 若当前的cur和比较的值相同则什么都不做cur++
 *
 * 相当于小于的数，推着等于的数前进，当右边界与cur相交的时候则完成
*/
public class NetherlandsFlag {
    /**
    * @param arr 需要排序的数组
      @param L 数组的左边界
      @param R 数组的右边界
      @param num 需要比较的数字num
    */
    public static int[] partition(int[] arr,int L ,int R ,int num){
        //定义左边界
        int less=L-1;
        //定义右边界
        int more=R+1;
        //定义当前的位置
        int cur=L;
        while (cur < more){
            if (arr[cur] < num){
                //左边界推着等于num的数往前走
                swap(arr,++less,cur++);
            }else if (arr[cur] >num){
                //交换大于num数字的位置
                swap(arr,--more,cur);
            }else {
                //arr[cur] =num
                cur++;
            }
        }
        //返回等于num区域的左边界和右边界
        return new int[]{less+1,more-1};
    }
    //交换连个数字的位置
    public static void swap(int[] arr, int L,int R){
        int tmp=arr[L];
        arr[L] =arr[R];
        arr[R] =tmp;
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
        int[] arr={4,7,8,4,6,7,6};
        partition(arr,0,arr.length-1,6);
        //print 4 4 6 6 7 8 7
        print(arr);
    }
}
