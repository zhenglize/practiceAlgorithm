package DP;
/**
*@author zhenglize
  打印所有字符串的全排列
*/
public class Print_All_Permutations {
    /**
     待打印的字符串，i为当前的位置
    */
    public static void printStr(char[] strs , int i){
        if (i == strs.length){
            System.out.println(String.valueOf(strs));
        }
        //j不断的++.交换位置构造排序方式
        for (int j = i; j < strs.length; j++) {
            swap(strs,i,j);
            printStr(strs, i+1);
        }
    }
    public static void swap(char[] arr, int i,int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        String str="bcd";
        char[] chars = str.toCharArray();
        printStr(chars,0);
    }
}
