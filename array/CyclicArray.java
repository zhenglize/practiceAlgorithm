package array;

import java.util.Scanner;

/**
*@author zhenglize
  手写实现环型队列，可以实现数据的复用
   判断队列满的条件为: (rear + 1) % maxsize = front
   判断队列中可用元素的个数为: (rear + maxsize - front) % maxsize
   判断队列是否为空的条件为 rear == front
*/
public class CyclicArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;
    //其中front是当前数组的第一个元素的位置，rear是当前数组的最后一个元素后一个位置
    public CyclicArray(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
        front=0;
        rear=0;
    }
    //判断队列是否满
    public boolean isFull(){
        return (rear+1) % maxSize ==front;
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
        //将元素添加发到rear对应的位置上
        arr[rear] =data;
        rear=(rear+1)%maxSize;
    }
    //去除队列中的元素
    public int poll(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的，取数据失败");
        }
        //将front的值保存起来
         int value =arr[front];
        //给front重新赋值
        front=(front +1) % maxSize;
        return value;
    }
    //查看队列头
    public int peek(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的，取数据失败");
        }
        return arr[front];
    }
    //查看队列全部数据
    public void printAllQueueData(){
        if (isEmpty()){
            throw new RuntimeException("队列是空的，取数据失败");
        }
        //front + getSize() 代表需要遍历的次数
        for (int i = front; i < front+getSize(); i++) {
            //i %maxsize为了使front + getSize() 不越界
            System.out.printf("arr[%d]=arr[%d]\n",i % maxSize,arr[i % maxSize]);
    }
    }
    //查看队列中的元素个数
    public int getSize(){
        return (maxSize+rear-front) %maxSize;
    }
    public static void main(String[] args) {
        CyclicArray arrayQueue=new CyclicArray(4);
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
