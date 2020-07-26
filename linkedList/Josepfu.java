package linkedList;
/**
*@author zhenglize
  约瑟夫环型问题
*/
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList linkedList=new CircleSingleLinkedList();
        linkedList.addBoy(5);
        linkedList.showBoy();
        System.out.println();
        linkedList.countBoy(1,2,5);
        /**
         小孩出圈2
         小孩出圈4
         小孩出圈1
         小孩出圈5
         最后一个小孩是3
        */
    }
}
class CircleSingleLinkedList{
    //头结点
    private Boy first=null;
    //添加节点,从1到nums形成环状链表
    public void addBoy(int nums){
        //对nums的值进行判断
        if (nums <1){
            System.out.println("添加的数据不对");
            return;
        }
        Boy cur=null;
        for (int i = 1; i <= nums; i++) {
            Boy boy=new Boy(i);
            if (i ==1){
                first=boy;
                first.setNext(first);
                cur=first;
            }else {
                cur.setNext(boy);
                boy.setNext(first);
                cur=boy;
            }
        }
    }
    //小孩出圈
    /**
    *@author zhenglize
     @param startNum 从第几个小孩开始数数
     @param countNum 一次数几下
     @param nums 共有多少个小孩
    */
    public void countBoy(int startNum,int countNum,int nums){
        if (startNum <0 || first ==null || startNum >nums){
            System.out.println("您输入的数据有误，请重新输入~");
            return;
        }
        //定义辅助节点help，使其位于环型链表的最后一个节点
        Boy help=first;
        while (help.getNext() != first) {
            help = help.getNext();
        }
        //定位到第startnum开始数数
        for (int i = 0; i < startNum - 1; i++) {
            first=first.getNext();
            help=help.getNext();
        }
        //通过查几下判断哪个小孩出圈
        while (true){
            //只剩最后一个小孩，退出循环
            if (first ==help){
                break;
            }
            //移动到出圈位置的小孩
            for (int i = 0; i < countNum - 1; i++) {
                first=first.getNext();
                help=help.getNext();
            }
            System.out.printf("小孩出圈%d \n",first.getNum());
            //去除出圈的小孩重新形成循环链表
            first=first.getNext();
            help.setNext(first);
        }
        System.out.printf("最后一个小孩是%d \n",first.getNum());
    }
    //打印所有的节点
    public void showBoy(){
        if (first ==null){
            System.out.println("该链表是空的");
            return;
        }
        Boy cur=first;
        while (true){
            System.out.print(cur.getNum() +" ");
            if (cur.getNext() ==first){
                break;
            }
            cur=cur.getNext();
        }
    }
}
class Boy{
    private int num;
    private Boy next;
    public Boy(int num){
        this.num=num;
    }
    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
