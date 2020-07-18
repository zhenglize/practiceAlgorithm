package array;

import java.util.Scanner;

/**
*@author zhenglize
  使用数组实现一个队列
*/
public class ArrayQueue {
     private int maxSize;
     private int front;
     private int rear;
     private int[] arr;

     public ArrayQueue(int maxSize){
         //声明数组的最大值
         this.maxSize=maxSize;
         //初始化这个数组
         arr=new int[maxSize];
         //front代表的是队列的头位置的前一个位置
         front=-1;
         //rear代表队列的最后一个位置
         rear=-1;
     }
     //判断队列是否满
    public boolean isFull(){
         return rear == maxSize -1;
    }
    //判断队列是否为空
    public boolean isEmpty(){
         return front==rear;
    }
    //向队列中添加元素
    public void add(int data){
         if (isFull()){
             System.out.println("队列已满，添加失败");
             return;
         }
         //队列尾增长
         rear++;
         arr[rear] =data;
    }
    //去除队列中的元素
    public int poll(){
         if (isEmpty()){
             throw new RuntimeException("队列是空的，取数据失败");
         }
         front++;
         return arr[front];
    }
    //查看队列全部数据
    public void printAllQueueData(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的，取数据失败");
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=arr[%d]\n",i,arr[i]);
        }
    }
    //查看队列头
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的，取数据失败");
        }
        return arr[front+1];
    }

    public static void main(String[] args) {
        ArrayQueue arrayQueue=new ArrayQueue(3);
        Scanner scanner=new Scanner(System.in);
        boolean flag=true;
        char key=' ';
        while (flag){
            System.out.println("显示队列数据 p");
            System.out.println("向队列中添加数据 a");
            System.out.println("查看队列头部的元素 l");
            System.out.println("取出队列中一个元素 h");
            System.out.println("退出当前程序 e");
            //接受第一个字符
            key=scanner.next().charAt(0);
            switch (key){
                case 'p':
                    try{
                        arrayQueue.printAllQueueData();
                    }catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case  'a' :
                    System.out.println("请向队列中输入一个数");
                    int value=scanner.nextInt();
                    arrayQueue.add(value);
                    break;
                case 'l' :
                    try{
                        int i = arrayQueue.peek();
                        System.out.println("队列头部的元素是"+i);
                    }catch(Exception e){
                        e.getMessage();
                    }
                    break;
                case 'h' :
                    try {
                        int poll = arrayQueue.poll();
                        System.out.println("取出的数字是:"+poll);
                    }catch (Exception e){
                        e.getMessage();
                    }
                    break;
                case 'e':
                    scanner.close();
                    flag=false;
                    break;
                default:
                    break;
            }
        }
    }
}
