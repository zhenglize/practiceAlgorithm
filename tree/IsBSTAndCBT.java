package tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
*@author zhenglize
 搜索二叉树:对于任意节点左子树比他小，右子树比他大
 如何判断是搜索二叉树?
 二叉树中序遍历的结果是依次升序的。
 完全二叉树:它节点的顺序是否为从左到右依次补齐的
*/
public class IsBSTAndCBT {
    //判断一个数是否是搜索二叉树，在中序遍历的基础上修改
    public static boolean IsBST(Node head){
        System.out.println("判断一个树是否是搜索二叉树");
        int pre=Integer.MIN_VALUE;
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
                   //若前一个数pre小于当前的head.value的值则继续这个流程，若大于返回结果
                   if (head.value > pre){
                       pre=head.value;
                   }else {
                       return false;
                   }
                    head=head.right;
                }
            }
        }
        return true;
    }
    //判断一个二叉树是否为完全二叉树
    public static boolean isCBT(Node head){
        if (head ==null){
            return true;
        }
        //若当前节点它的左孩子不为空，右孩子为空，或者都为空，进入此模式，剩下的节点都是叶子节点
        boolean leaf=false;
        Node l=null;
        Node r=null;
        Queue<Node> queue=new LinkedList<>();
        queue.offer(head);
        //只有当前节点两个孩子都有会往下走，若有左没有进入leaf模式，判断剩下的节点是不是叶子节点
        while (!queue.isEmpty()){
            head=queue.poll();
            l=head.left;
            r=head.right;
            if ((leaf && (l !=null || r!=null))
                    || (l==null && r!=null)){
                return false;
            }
            if (l !=null){
                queue.offer(l);
            }
            if (r !=null){
                queue.offer(r);
            }
            if (l==null || r==null){
                leaf=true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Node head = new Node(4);
        head.left = new Node(2);
        head.right = new Node(6);
        head.left.left = new Node(1);
        head.left.right = new Node(3);
        head.right.left = new Node(5);
        boolean b = IsBST(head);
        System.out.println("是否为搜索二叉树:"+b);
        System.out.println("是否为完全二叉树:"+isCBT(head));
    }
}
