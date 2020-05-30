package sort;
/**
 * @author zhenglize
*桶排序的实际应用：给定一个数组，求如果排序之后，相邻两数的最大差值，
 * 要求时间复杂度O(N)，且要求不能用非基于比较的排序。
 *
*/
public class MaxGap {
    public static int getMax(int[] arr){
        if (arr == null || arr.length <2){
            return 0;
        }
        //找出数组中的最大值和最小值
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int len=arr.length;
        for (int i = 0; i < arr.length; i++) {
            max=Math.max(max,arr[i]);
            min=Math.min(min,arr[i]);
        }
        //若最大值等于最小值代表只有一种数
        if (max == min){
            return 0;
        }
        int[] maxs=new int[len+1];
        int[] mins=new int[len+1];
        boolean[] hasNums=new boolean[len+1];
        //记录分配到了几号桶
        int bid=0;
        //遍历数组找出每个桶的最大值和最小值
        for (int i = 0; i < len; i++) {
            bid=bucket(max,min,len,arr[i]);
            mins[bid]=hasNums[bid] ? Math.min(mins[bid],arr[i]):arr[i];
            maxs[bid]=hasNums[bid] ? Math.max(maxs[bid],arr[i]):arr[i];
            hasNums[bid]=true;
        }
        int res=0;
        int data=maxs[0];
        int i=1;
        for ( ; i <len+1 ; i++) {
            if (hasNums[i]){
                res=Math.max(res,mins[i]-data);
                data=maxs[i];
            }
        }
        return res;
    }
    /**
     * 返回当前的数在第几号桶
    * @param max 最大值
     * @param min 最小值
     * @param num 当前值
     * @param len 数组的长度
    */
    public static int bucket(int max,int min ,int len ,int num){
        return (num-min)*len/(max-min);
    }

    public static void main(String[] args) {
        int[] arr={1,2,5,6,7,997};
        System.out.println(getMax(arr)); // print  990
    }
}
