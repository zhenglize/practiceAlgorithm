package sort;
/**
 * @author zhenglize
*快排设计思路
 * 在荷兰国旗问题的基础上，分好的一个小于等于和大于区域，之后接着递归，进行partition过程直到左边界小于右边界为止
    时间复杂度为  O（N*logN）额外空间复杂度O(logN)因为需要记住断点的位置，是一个不断的二分的过程，一个二叉树的高度
 */
public class quickSort {
    public static void quickSort(int[] arr){
        if (arr ==null || arr.length<2){
            return;
        }
        sortProcess(arr,0,arr.length-1);
    }
/**
*@param arr 待排的数组
 @param L 数组的左边界
 @param R 数组的右边界
*/
    private static void sortProcess(int[] arr, int L, int R) {
        if (L<R){
            //为了避免数据状态不好的情况，这里使用随机快排，用数组中随机的一个数，与最后一个数交换
            swap(arr, (int) (L+(Math.random()*(R-L+1))),R);
            int[] p=partition(arr,L,R);
            sortProcess(arr,L,p[0]-1);
            sortProcess(arr,p[1]+1,R);
        }
    }
    /**
    * @param arr 进行partition过程的数组
      @param L 数组的左边界
     @param R 数组的右边界,待比较的那个num
    */
    public static int[] partition(int[] arr,int L,int R){
        int less=L-1;
        //之所以不是荷兰国旗问题的R+1，是因为快排把最后一个位置的值，作为比较值
        int more=R;
        while (L<more){
            if (arr[L] <arr[R]){
                //小于R，左边界右移，cur++
                swap(arr,++less,L++);
            }else if (arr[L] >arr[R]){
                //大于，交换两数的位置进行下一次比较
                swap(arr,--more,L);
            }else {
                //相等cur++
                L++;
            }
        }
        //当分配完成后，交换比较数和右边界指针的位置完成本次排序
        swap(arr,more,R);
        //返回等于num的左边界和右边界
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
        int[] arr={5,23,7,2,9,3213,325,52};
        quickSort(arr);
        print(arr); //print 2 5 7 9 23 52 325 3213
    }
}
