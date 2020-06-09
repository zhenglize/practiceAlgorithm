package linkedList;
/**
*@author zhenglize
将单向链表按某值划分成左边小、中间相等、右边大的形式
【题目】 给定一个单向链表的头节点head，节点的值类型是整型，再给定一个
整数pivot。实现一个调整链表的函数，将链表调整为左部分都是值小于 pivot
的节点，中间部分都是值等于pivot的节点，右部分都是值大于 pivot的节点。
除这个要求外，对调整后的节点顺序没有更多的要求。 例如：链表9->0->4->5->1，pivot=3。
调整后链表可以是1->0->4->9->5，也可以是0->1->9->5->4。总之，满足左部分都是小于3的节点，
中间部分都是等于3的节点，右部分都是大于3的节点即可。对某部分内部的节点顺序不做要求。

 简单的思路使用荷兰国旗问题进行一次外排
*/
public class SmallerEqualBigger {
    static class Node{
        Node next;
        int data;
        public Node(int value){
            this.data=value;
        }
    }
    public static Node listPartition(Node head,int pivot){
        if (head == null){
            return head;
        }
        //获得链表的长度
        Node cur=head;
        int i=0;
        while (cur !=null){
            i++;
            cur=cur.next;
        }
        //创建一个和链表长度相等的数组
        Node[] help=new Node[i];
        cur=head;
        //将链表中的元素，赋值到数组中
        for (i=0 ; i!= help.length; i++ ) {
            help[i]=cur;
            cur=cur.next;
        }
        //进行partition过程
        partitionProcess(help,pivot);
        cur=help[0];
        //将数组串成链表
        for (int j = 1; j !=help.length ; j++) {
            cur.next=help[j];
            cur=cur.next;
        }
        cur.next=null;
        return help[0];
    }
    //类似于荷兰国旗问题的外排
    private static void partitionProcess(Node[] help, int pivot) {
         int index=0;
         int large=help.length;
         int small=-1;
         while (index != large){
             if (help[index].data < pivot){
                 swap(help,++small,index++);
             }else if (help[index].data==pivot){
                 index++;
             }else {
                 swap(help,--large,index);
             }
         }
    }
    //交换两个节点的位置
    public static void swap(Node[] data,int i,int j){
        Node temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
    public static void printLinkedList(Node head){
        while (head !=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }

    public static void main(String[] args) {
        Node head=new Node(9);
        head.next=new Node(0);
        head.next.next=new Node(4);
        head.next.next.next=new Node(5);
        head.next.next.next.next=new Node(1);
        int pivot=3;
        printLinkedList(head);
        Node node = listPartition(head, pivot);
        System.out.println();
        printLinkedList(node);
    }
}
