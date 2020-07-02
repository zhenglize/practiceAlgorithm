package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
*@author zhenglize
 二叉树的序列化与反序列化
 序列化:也叫持久化，把二叉树的结构用一个字符串保存起来
        设计思路:当遇到没有子树的时候就用#!这样的结构分割，每两个子节点用！分割
*/
public class SerializeAndReconstructTree {
    //使用前序遍历进行二叉树的持久化
    public static String serialByPre(Node head){
        if (head == null){
            return "#!";
        }
        String res=head.value+"!";
        res+=serialByPre(head.left);
        res+=serialByPre(head.right);
        return res;
    }
    //使用先序遍历进行二叉树的反序列化
    public static Node reconByPre(String nodeString){
        if (nodeString == null){
            return null;
        }
        String[] nodes = nodeString.split("!");
        //将字符串的内容添加到队列中方便操作
        Queue<String> queue=new LinkedList<>();
        for (int i = 0; i < nodes.length; i++) {
            queue.add(nodes[i]);
        }
        return reconPreOrder(queue);
    }

    private static Node reconPreOrder(Queue<String> queue) {
        String value=queue.poll();
        if ("#".equals(value)){
            return null;
        }
        //由于是先序遍历序列化的，所以使用中左右的顺序进行反序列化
        Node head=new Node(Integer.valueOf(value));
        head.left=reconPreOrder(queue);
        head.right=reconPreOrder(queue);
        return head;
    }
}
