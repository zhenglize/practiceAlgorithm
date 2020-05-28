package sort;
/**
*用递归的方法，实现找出数组中的最大值的方法
 * 递归就是系统帮我们压栈出栈的
 * master公式的使用(估计递归行为的时间复杂度)
 * T(N)         =        a*T(N/b) + O(N^d)
 * 递归行为的时间复杂度    a为子递归过程发生的次数，b为子过程的样本量   O(N^d)为除去子过程，额外的复杂度
 * 1) log(b,a) > d -> 复杂度为O(N^log(b,a))
 * 2) log(b,a) = d -> 复杂度为O(N^d * logN)
 * 3) log(b,a) < d -> 复杂度为O(N^d)
*/
public class getMax {
    //给定一个数组和它的左边界以及右边界找出最大值
   public static int getMax(int[] arr,int L,int R){
        if (L == R){
            return arr[L];
        }
        int mid=(L+R)/2;
        //找出左边的最大值与右边的最大值
        int maxLeft=getMax(arr,L,mid);
        int maxRight=getMax(arr,mid+1,R);
        return Math.max(maxLeft,maxRight);
   }
   //测试方法
    public static void main(String[] args) {
        int[] arr={4,3,7,2};
        //print
        System.out.println(getMax(arr, 0, arr.length-1));
    }
}
