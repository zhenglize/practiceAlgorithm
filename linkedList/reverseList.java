package linkedList;

/**
 * @author zhenglize
 * 【题目】:分别实现翻转单项链表和反转双向链表的函数
 * 【要求】:如果链表的长度为N，时间复杂度要求O（N），额外空间复杂度要求为O（1）
 */
public class reverseList {
 //单向链表的节点
 public static class Node {
  Node next;
  int data;

  public Node(int data) {
   this.data = data;
  }
 }

 /**
  * 反转一个链表，传入头结点
  *
  * @param head 需要进行反转链表的头结点
  */
 public static Node reverseList(Node head) {
  Node pre = null;
  Node next = null;
  while (head != null) {
   next = head.next;
   head.next = pre;
   pre = head;
   head = next;
  }
  return pre;
 }

 //双向链表的节点
 public static class DoubleNode {
  //双向链表有前指针和后指针两个节点
  DoubleNode next;
  DoubleNode front;
  int data;

  public DoubleNode(int data) {
   this.data = data;
  }
 }

 /**
  * 反转双向链表返回头节点
  */
 public static DoubleNode reverseDoubleNode(DoubleNode head) {
  DoubleNode pre = null;
  DoubleNode next = null;
  while (head != null) {
   next = head.next;
   head.next = pre;
   head.front = next;
   pre = head;
   head = next;
  }
  return pre;
 }


 public static void main(String[] args) {
  Node head = new Node(1);
  head.next = new Node(2);
  head.next.next = new Node(3);
  printNodeInfo(head);
  System.out.println();
  Node reverseNode = reverseList(head);
  printNodeInfo(reverseNode);
  DoubleNode head2 = new DoubleNode(1);
  head2.next = new DoubleNode(2);
  head2.next.front = head2;
  head2.next.next = new DoubleNode(3);
  head2.next.next.front = head2.next;
  head2.next.next.next = new DoubleNode(4);
  head2.next.next.next.front = head2.next.next;
  printDoubleNodeInfo(head2);
  System.out.println();
  printDoubleNodeInfo(reverseDoubleNode(head2));
  /**
     print：
      1-->2-->3
      3-->2-->1
      1-->2-->3-->4
      4-->3-->2-->1
      4-->3-->2-->1
      1-->2-->3-->4
  */
 }

 /**
  * 打印链表
  */
 public static void printNodeInfo(Node head) {
  while (head != null) {
   if (head.next != null)
    System.out.print(head.data + "-->");
   if (head.next == null)
    System.out.println(head.data);
   head = head.next;
  }
 }

 /**
  * 打印双向链表
  */
 public static void printDoubleNodeInfo(DoubleNode head) {
  DoubleNode end = null;
  while (head != null) {
   if (head.next != null) {
    System.out.print(head.data + "-->");
   }
   if (head.next == null) {
    System.out.print(head.data);
   }
   end = head;
   head = head.next;
  }
  System.out.println();
  while (end != null) {
   if (end.front != null) {
    System.out.print(end.data + "-->");
   }
   if (end.front == null)
    System.out.print(end.data);
   end = end.front;
  }
  System.out.println();
 }
}

