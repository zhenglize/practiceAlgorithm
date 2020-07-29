package DP;
/**
*@author zhenglize
  8皇后问题
*/
public class Queue8 {
   int max=8;
   //声明一个一味数组，数组的索引代表它是第几个皇后，数组索引位置的值，代表它是在第几行
   int[] map=new int[max];
    static int count=0;
    public static void main(String[] args) {
        Queue8 queue8=new Queue8();
        queue8.check(0);
        System.out.println("一共有"+count+"种解法");
    }
    private void check(int n){
        if (n ==max){
            print();
            return;
        }
        for (int i = 0; i < map.length; i++) {
            //放置第n个皇后的位置
            map[n]=i;
            if (judge(n)){
                check(n+1);
            }
            //若不能放置则继续执行for循环放置皇后在下一个位置
        }
    }
    //判断第n个皇后位置之前的位置是否为不能放置的
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            //第一个判断条件是判断是否在同一列，第二个判断条件，判断说是否在对角线上
            if (map[n] == map[i] || Math.abs(n-i) == Math.abs(map[n]-map[i])){
                return false;
            }
        }
        return true;
    }
    //打印这个一维数组
    public void print(){
        count++;
        for (int i = 0; i < map.length; i++) {
            System.out.print(map[i]+" ");
        }
        System.out.println();
    }
}

