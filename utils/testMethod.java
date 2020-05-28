package utils;

import java.util.Arrays;

/**
*@author zhenglize
 * 使用对数器来验证方法的正确性，下面是使用对数器的流程
 * 0，有一个你想要测的方法a，
 * 1，实现一个绝对正确但是复杂度不好的方法b，
 * 2，实现一个随机样本产生器
 * 3，实现比对的方法
 * 4，把方法a和方法b比对很多次来验证方法a是否正确。
 * 5，如果有一个样本使得比对出错，打印样本分析是哪个方法出
 * 错
 * 6，当样本数量很多时比对测试依然正确，可以确定方法a已经正确。
 *
*/
public class testMethod {
    //1.待测量正确的方法
    public static void bubbleSort(int[] arr){
        //特殊情况进行判断
        if (arr == null || arr.length <2){
            return;
        }
        //每次排好最后一个位置的数，随后索引向前
        for(int end=arr.length-1 ; end >0 ;end--){
            for (int i = 0; i < end; i++) {
                //如果前一个数字大于后一个数字则交换位置
                if (arr[i] > arr[i+1]){
                    swap(arr,i,i+1);
                }
            }
        }
    }
    /**
     *交换两个数组中索引元素位置的方法
     */
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    //2.绝对正确但复杂度不好的方法
    public static void rightMethod(int[] arr){
        Arrays.sort(arr);
    }
    //3.随机样本产生器
    public static int[] generateRandomArray(int size,int value){
        //生成[0,size]这样随机长度的数组
        int[] arr=new int[(int) ((size+1)*(Math.random()))];
        for (int i = 0; i <arr.length ; i++) {
            //给数组中的元素赋以随机的值
            arr[i]= (int) (value*(Math.random())-(value-1)*Math.random());
        }
        return arr;
    }
    //4.比对方法
    public static boolean isEqual(int[] arr1,int[] arr2){
        //如果数组中的元素有一个为空，另一个不为空返回false
        if ((arr1==null && arr2!=null) || (arr1!=null && arr2==null)){
            return false;
        }
        //如果两个数组都为空，返回true
        if ((arr1 == null) && (arr2 ==null)){
            return true;
        }
        //若待测的两个数组长度不相同，则返回false
        if (arr1.length !=arr2.length){
            return false;
        }
        for (int i = 0; i <arr1.length ; i++) {
            //数组中的值不相同返回false
            if (arr1[i] != arr2[i]){
                return false;
            }
        }
        return true;
    }
    //5.复制数组中的元素
    public static int[] copyArray(int[] arr){
        if (arr == null){
            return null;
        }
        //复制一个一样的数组
        int[] res=new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i]=arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int testTime=500000;
        int size=100;
        int value=100;
        //判断是否成功
        boolean success=true;
        //测试数据
        for (int i = 0; i < testTime; i++) {
            //产生随机长度的数组
            int[] arr = generateRandomArray(size, value);
            int[] arr1 = copyArray(arr);
            int[] arr2= copyArray(arr);
            //用正确和自己的方法排序
            bubbleSort(arr1);
            rightMethod(arr2);
            if (!isEqual(arr1,arr2)){
                //存在不相同的情况,打印数组中的元素跳出循环
                success=false;
                print(arr1);
                break;
            }
        }
        System.out.println(success ? "nice!!!" : "Fucking fucked");
    }
    /**
     *打印数组中元素的方法
     */
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}
