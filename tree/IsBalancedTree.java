package tree;
/**
*@author zhenglize
 * 平衡二叉树:对于任一一个节点它的左子树和右子树的高度差不会超过一
  判断一棵树是否是平衡二叉树
*/
public class IsBalancedTree {
    public static class ReturnData{
        public boolean isBalanced;
        public int high;

        public ReturnData(boolean isBalanced, int high) {
            this.isBalanced = isBalanced;
            this.high = high;
        }

        public boolean isBalanced() {
            return isBalanced;
        }

        public void setBalanced(boolean balanced) {
            isBalanced = balanced;
        }

        public int getHigh() {
            return high;
        }

        public void setHigh(int high) {
            this.high = high;
        }
    }

    public static ReturnData process(Node head){
        if (head == null){
            return new ReturnData(true,0);
        }
        ReturnData leftData = process(head.left);
        //如果左右子树不平衡则直接返回false
        if (!leftData.isBalanced()){
            return new ReturnData(false,0);
        }
        ReturnData rightData = process(head.right);
        if (!rightData.isBalanced()){
            return new ReturnData(false,0);
        }
        //如果高度差大致1，返回false
        if (Math.abs(leftData.getHigh() - rightData.getHigh())>1){
            return new ReturnData(false,0);
        }
        return new ReturnData(true,
                Math.max(leftData.getHigh(),rightData.getHigh())+1);
    }
    //判断是否是二叉树的方法
    public static boolean isBalancedTree(Node head){
        return process(head).isBalanced();
    }
}
