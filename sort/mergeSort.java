package sort;
/**
*@author zhenglize
 * 归并排序
 * 排序思想为把一个数组分为两部分，先把左边那部分排好序，再把右边的部分排好序，之后用外排的方式将总体排好序
 * 时间复杂度 O(N*logN)
*/
public class mergeSort {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length<2){
            return;
        }
        mergeProcess(arr,0,arr.length-1);
    }

    private static void mergeProcess(int[] arr, int L, int R) {
        if (L==R){
            return;
        }
        int mid=(L+R)/2;
        //将左边的那部分排好序，再把右边的部分排好序,之后再整体再排好序
        mergeProcess(arr,L,mid);  //T（n/2）
        mergeProcess(arr,mid+1,R);//T（n/2）
        merge(arr,L,mid,R);//O(n)
        //带入master公式，时间复杂度为 T(n)=2T(n/2)+O(n) 时间复杂度为----->>>> O(N*logN)
    }
    //使用外排的方法将整体排好序
    private static void merge(int[] arr, int L, int mid, int R) {
        int[] help=new int[R-L+1];
        int i=0;
        int p1=L;
        int p2=mid+1;
        while (p1 <=mid && p2<=R){
            help[i++]=arr[p1] < arr[p2] ? arr[p1++] :arr[p2++];
        }
        //将剩下的元素拷贝至数组中，只会执行一个
        while (p1 <=mid){
            help[i++]=arr[p1++];
        }
        while (p2<=R){
            help[i++]=arr[p2++];
        }
        //将help数组中的内容拷贝至arr中
        for (i = 0; i < help.length; i++) {
            arr[L+i]=help[i];
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
        int[] arr={4,6,2,7,1,9};
        mergeSort(arr);
        print(arr);
        //print 1 2 4 6 7 9
    }
}
