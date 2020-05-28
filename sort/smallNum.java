package sort;
/**
*小和问题
 * 使用归并排序的思想来解决
 * 题目:
 * 在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组
 * 的小和。
 * 例子：
 * [1,3,4,2,5]
 * 1左边比1小的数，没有；
 * 3左边比3小的数，1；
 * 4左边比4小的数，1、3；
 * 2左边比2小的数，1；
 * 5左边比5小的数，1、3、4、2；
 * 所以小和为1+1+3+1+1+3+4+2=16
*/
public class smallNum {
    public static int smallNum(int[] arr){
        if (arr == null || arr.length <2){
            return 0;
        }
        return mergeSort(arr,0,arr.length-1);
    }
    public static int mergeSort(int[] arr,int L,int R){
        if (L==R){
            return 0;
        }
        int mid =(L+R)/2;
        //左部分和右部分的小和，加上总体的merge过程的小和
        return mergeSort(arr,L,mid) +mergeSort(arr,mid+1,R)+merge(arr,L,mid,R);
    }

    private static int merge(int[] arr, int L, int mid, int r) {
        int[] help=new int[r-L+1];
        int i=0;
        int p1=L;
        int p2=mid+1;
        int res=0;
        while (p1 <=mid && p2 <=r){
            //计算小和的核心逻辑
            res+=arr[p1]<arr[p2]?(r-p2+1)*arr[p1] :0;
            help[i++]=arr[p1] < arr[p2] ? arr[p1++] :arr[p2++];
        }
        while (p1<=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=r){
            help[i++]=arr[p2++];
        }
        for (int j = 0; j < help.length; j++) {
            arr[j+L]=help[j];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr={1,3,4,2,5};
        System.out.println(smallNum(arr));
    }
}
