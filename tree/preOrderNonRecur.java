package tree;

import java.util.Stack;

/**
*@author zhenglize
  不使用递归的方法，实现先序遍历二叉树
*/
public class preOrderNonRecur {
    public static void preOrderNonRecur(Node head){
        System.out.println("非递归方式，先序遍历二叉树结构");
        if (head !=null){
            Stack<Node> stack=new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head=stack.pop();
                System.out.print(head.value+" ");
                //先压右后压左
                if (head.right!=null){
                    stack.push(head.right);
                }
                if (head.left !=null){
                    stack.push(head.left);
                }
            }
        }
    }
}
