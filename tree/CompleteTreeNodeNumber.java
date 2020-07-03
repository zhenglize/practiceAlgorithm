package tree;
/**
*@author zhenglize
已知一棵完全二叉树，求其节点的个数
要求：时间复杂度低于O(N)，N为这棵树的节点个数
*/
public class CompleteTreeNodeNumber {

    public static int NodeNum(Node head){
        if (head ==null){
            return 0;
        }
        return bs(head,1,deepHeight(head,1));
    }

    /**
     求出该树的节点个数
     @param head 当前节点
     @param level 当前节点在第几层
     @param h 树的深度
    */
    public static int bs(Node head,int level,int h){
        //该节点到了叶子节点，只有一个节点
        if (level ==h){
            return 1;
        }
        //判断当前节点的右孩子到没到最后一层,如果到了最后一层它的左子树是满的，如果没到右子树是满的
        if (deepHeight(head.right,level+1) ==h){
            return (1 << (h-level))+bs(head.right,level+1,h);
        }else {
            return (1 << (h-level-1))+bs(head.left,level+1,h);
        }
    }
    //查看这颗树的深度
    /**
     * @param head 当前节点
      @param level 当前节点的高度
    */
    public static int deepHeight(Node head,int level){
        while (head!=null){
            level++;
            head=head.left;
        }
        return level-1;
    }
}
