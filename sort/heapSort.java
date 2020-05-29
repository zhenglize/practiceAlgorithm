package sort;
/**
 * @author zhenglize
*堆排序
 * 实际上堆是一个完全二叉树
 * 完全二叉树可以理解为:满二叉树是完全二叉树，若不是满二叉树的话，它的叶节点是从左到右依次补齐的它也是完全二叉树
 * 可以把数组也理解为一颗完全二叉树
 * 对一个一个数组来说，它的索引位置i
 *    2*i+1 是它的左孩子的位置
 *    2*i+2 是它的右孩子的位置
 *    i-1/2  是它的父节点的位置
 *    堆 ------------》》》就是完全二叉树
 *    大根堆:对于堆中的任意一颗子树，它的最大值都是他的头结点，这样的完全二叉树叫大根堆
 *    小根堆：对于堆中的任意一颗子树，它的最小值都是他的头结点，这样的完全二叉树叫小根堆
 *
*/
public class heapSort {
    public static void heapSort(int[] arr){
        if (arr == null || arr.length <2){
            return;
        }
        //将数组变成大根堆
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr,i);
        }
        //先排好最后一个数
        int heapSize=arr.length;
        swap(arr,0,--heapSize);
        //循环操作，进行heapify直到排好序为止
        while (heapSize >0){
            heapify(arr,0,heapSize);
            swap(arr,0,--heapSize);
        }
    }
    /**
    *将一个数组变成一个大根堆，复杂度为O（N）
     * @param arr 变成堆的师叔祖
     * @param index 添加index位置的元素，使数组重新变成一个大根堆
    */
    public static void heapInsert(int[] arr , int index){
        while (arr[index] > arr[(index-1)/2]){
            //不断的向上找比index大的父节点，如果有就交换，没有就停止
            swap(arr,index,(index-1)/2);
            index=(index-1)/2;
        }
    }
    //交换连个数字的位置
    public static void swap(int[] arr, int L,int R){
        int tmp=arr[L];
        arr[L] =arr[R];
        arr[R] =tmp;
    }
    /**
    *当堆中某一个索引位置的元素发生变化时，使其重新变成一个大根堆
     * @param arr 变成堆的师叔祖
     * @param index 当index位置的元素发生了变化，使数组重新变成一个大根堆
     * @param heapSize 堆的界限
    */
    public static void heapify(int[] arr,int index,int heapSize){
        //找到它的坐孩子
        int left=2*index+1;
        while (left <heapSize){
            //找出它的左右孩子中较大的那个
            int largest= (left+1 < heapSize) && arr[left+1] >arr[left] ? left+1:left;
            //和index相比找出较大的那个
            largest=arr[index] > arr[largest] ? index :largest;
            //若相等则已经是大根堆了
            if (index == largest){
                break;
            }
            //index位置的元素更大，交换位置
            swap(arr,index,largest);
            //进行下一次的判断操作
            index=largest;
            left=2*index+1;
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
        int[] arr={5,23,7,2,9,3213,325,52};
        heapSort(arr);
        print(arr); //print 2 5 7 9 23 52 325 3213
    }
}
