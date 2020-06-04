package linkedList;

import java.util.Stack;

/**
*@author zhenglize
判断一个链表是否为回文结构
【题目】 给定一个链表的头节点head，请判断该链表是否为回文结构。
例如： 1->2->1，返回true。 1->2->2->1，返回true。 15->6->15，返回true。 1->2->3，返回false。
进阶： 如果链表长度为N，时间复杂度达到O(N)，额外空间复杂度达到O(1)。
*/
public class IsPalindromeList {
    static class Node{
        Node next;
        int data;
        public Node(int data){
            this.data=data;
        }
    }
    //使用栈结构来判断是否回文
    public static boolean isPalindrome1(Node head){
        Node cur=head;
        Stack<Node> stack=new Stack<>();
        //将链表的所有节点放入栈中
        while (cur !=null){
            stack.push(cur);
            cur=cur.next;
        }
        //弹出栈中的元素进行比对
        while (head != null){
            if (stack.pop().data !=head.data){
                return false;
            }
            head=head.next;
        }
        return true;
    }
    //利用快指针一次走两步，慢指针一次走一步，添加回文结构的一半至栈中，进行比对
    public static boolean isPalindrome2(Node head){
        if (head == null || head.next ==null){
            return true;
        }
        //快指针
        Node cur=head;
        //慢指针,保证快指针走完，慢指针在中点的下面那个位置
        Node right=head.next;
        while (cur.next !=null && cur.next.next !=null){
            right=right.next;
            cur=cur.next.next;
        }
        //将链表的下一半添加至栈中
        Stack<Node> stack=new Stack<>();
        while (right !=null){
            stack.push(right);
            right=right.next;
        }
        //弹出栈中的元素进行比对操作
        while (!stack.isEmpty()){
            if (stack.pop().data != head.data){
                return false;
            }
            head=head.next;
        }
        return true;
    }
    //不需要额外空间完成判断过程
    public static boolean isPalindrome3(Node head){
        if (head == null || head.next == null){
            return true;
        }
        Node n1=head;
        Node n2=head;
        //确定中点的位置   find mid node
        while (n2.next !=null && n2.next.next !=null){
            n1=n1.next;
            n2=n2.next.next;
        }
        //保存回文链表右半段的第一个  n2 -> right part first node
        n2=n1.next;
        //中间节点的next至空  mid.next -> null
        n1.next=null;
        Node n3=null;
        //反转右边的链表  right part convert
        while (n2 !=null){
            //保存下来右边第一个节点的下面那个节点   n3 -> save next node
            n3=n2.next;
            // next of right node convert
            n2.next=n1;
            // n1 move
            n1=n2;
            // n2 move
            n2=n3;
        }
        // n3 -> save last node
        n3=n1;
        // n2 -> left first node
        n2=head;
        boolean res=true;
        while (n1 !=null && n2 !=null){
            if (n1.data != n2.data){
                res=false;
                break;
            }
            // right to mid
            n1=n1.next;
            // left to mid
            n2=n2.next;
        }
        //还原整个链表结构
        n1=n3.next;
        n3.next=null;
        while (n1 !=null){
            n2=n1.next;
            n1.next=n3;
            n3=n1;
            n1=n2;
        }
        return res;
    }
    public static void main(String[] args) {

        Node head = null;
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

        head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);
        printLinkedList(head);
        System.out.print(isPalindrome1(head) + " | ");
        System.out.print(isPalindrome2(head) + " | ");
        System.out.println(isPalindrome3(head) + " | ");
        printLinkedList(head);
        System.out.println("=========================");

    }

    private static void printLinkedList(Node head) {
        while (head != null){
            System.out.print(head.data+" ");
            head=head.next;
        }
    }
}
