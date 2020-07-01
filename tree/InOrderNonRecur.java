package tree;

import java.util.Stack;

/**
*@author zhenglize
  中序遍历的非递归版
 当前节点为空。打印当前节点的值，当前节点向右。当前节点不空，将当前节点压入栈中，当前节点向左移动
*/
public class InOrderNonRecur {
    public static void inorderNonRecur(Node head){
        System.out.println("非递归方式，中序遍历一个二叉树");
        if (head != null){
            Stack<Node> stack=new Stack<>();
            while (!stack.isEmpty() || head !=null){
                //不空当前节点向左移动
                if (head !=null){
                    stack.push(head);
                    head=head.left;
                }else {
                    //为空，栈中弹出一个，同时向右移动
                    head=stack.pop();
                    System.out.print(head.value+" ");
                    head=head.right;
                }
            }
        }
    }
}
