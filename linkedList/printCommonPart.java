package linkedList;
/**
*@author zhenglize
打印两个有序链表的公共部分
【题目】 给定两个有序链表的头指针head1和head2，打印两个链表的公共部分
 解题思路:类似于归并排序的外排的merge过程
*/
public class printCommonPart {
    static class Node{
        Node next;
        int data;
        public Node(int value){
            this.data=value;
        }
    }
    public static void printCommonPart(Node head1,Node head2){
          while (head1 != null && head2 !=null){
              if (head1.data >head2.data){
                  head2=head2.next;
              }else if (head1.data < head2.data){
                  head1=head1.next;
              }else {
                  System.out.print(head1.data+" ");
                  head1=head1.next;
                  head2=head2.next;
              }
          }
        System.out.println();
    }
    public static void printList(Node head){
        while (head!=null){
            System.out.print(head.data+" ");
            head=head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node node1 = new Node(2);
        node1.next = new Node(3);
        node1.next.next = new Node(5);
        node1.next.next.next = new Node(6);

        Node node2 = new Node(1);
        node2.next = new Node(2);
        node2.next.next = new Node(5);
        node2.next.next.next = new Node(7);
        node2.next.next.next.next = new Node(8);

        printList(node1);
        printList(node2);
        printCommonPart(node1, node2);
    }
}
