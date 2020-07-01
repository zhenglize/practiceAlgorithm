package tree;

import java.util.Stack;

/**
*@author zhenglize
  非递归方式后序遍历二叉树
 实现思路是将先序遍历进行改写，变成先压左孩子，后压右孩子。编程中右左这样的顺序
 之后将所有结果添加到栈中，之后将栈中的元素倒出来，就变成了左右中这样的后序遍历
*/
public class posOrderNonRecur {
    public static void posOrderNonRecur(Node head){
        System.out.println("非递归方式后序遍历二叉树");
        if (head !=null){
            Stack<Node> stack=new Stack<>();
            Stack<Node> help=new Stack<>();
            stack.add(head);
            while (!stack.isEmpty()){
                head=stack.pop();
                help.push(head);
                if (head.left!=null){
                    stack.add(head.left);
                }
                if (head.right !=null){
                    stack.add(head.right);
                }
            }
            //将help中的元素打印出来
            while (!help.isEmpty()){
                System.out.print(help.pop().value+" ");
            }
        }
    }
}
