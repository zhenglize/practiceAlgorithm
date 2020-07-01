package tree;
/**
*@author zhenglize
 二叉树的前序、中序、后序遍历递归版
  递归行为时，每个节点还经过三次，如果打印节点的时机，是第一个来到节点的时候就是先序遍历，
   如果是第二次来到节点的时候就是中序遍历，如果是最后一次来到节点的时候，就是后序遍历
 前中后序都是从左子树开始打印的
*/
public class PreInPosTraversal {
    //二叉树的前序遍历递归版
    public static void preOrderRecur(Node head){
        if (head == null){
            return;
        }
        //打印当前节点
        System.out.print(head.value+" ");
        //寻找当前节点的左孩子
        preOrderRecur(head.left);
        //寻找当前节点的右孩子
        preOrderRecur(head.right);
    }
    //二叉树的中序遍历
    public static void inOrderRecur(Node head){
        if (head == null){
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.value+" ");
        inOrderRecur(head.right);
    }
    //二叉树的后序遍历
    public static void posOrderRecur(Node head){
        if (head ==null){
            return;
        }
        posOrderRecur(head.left);
        posOrderRecur(head.right);
        System.out.print(head.value+" ");
    }

    public static void main(String[] args) {
        Node head=new Node(1);
        head.left=new Node(2);
        head.right=new Node(3);
        head.left.left=new Node(4);
        head.left.right=new Node(5);
        head.right.left=new Node(6);
        head.right.right=new Node(7);
        /**
             1
          2      3
        4   5  6   7
        */
        //前序遍历  1 2 4 5 3 6 7
        preOrderRecur(head);
        System.out.println();
        //中序遍历 4 2 5 1 6 3 7
        inOrderRecur(head);
        System.out.println();
        //后序遍历 4 5 2 6 7 3 1
        posOrderRecur(head);
        System.out.println();
        //非递归方式先序遍历
        preOrderNonRecur.preOrderNonRecur(head);
        System.out.println();
        //非递归中序遍历
        InOrderNonRecur.inorderNonRecur(head);
        System.out.println();
        posOrderNonRecur.posOrderNonRecur(head);
    }
}
