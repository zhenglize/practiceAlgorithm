package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
*@author zhenglize
 二叉树按层序列化与反序列化
*/
public class serialByLevel {
    //二叉树按层序列化
    public static String serialByLevel(Node node){
        if (node ==null){
            return "#!";
        }
        String res=node.value+"!";
        Queue<Node> queue=new LinkedList<Node>();
        queue.add(node);
        while (!queue.isEmpty()){
            node=queue.poll();
            if (node.left !=null){
                res +=node.left.value+"!";
                queue.add(node.left);
            }else {
                res+="#!";
            }
            if (node.right !=null){
                res+=node.right.value+"!";
                queue.add(node.right);
            }else {
                res+="#!";
            }
        }
        return res;
    }
    //二叉树层序的反序列化
    public static Node reconByLevel(String values){
        String[] nodes = values.split("!");
        int index=0;
        Queue<Node> queue=new LinkedList<>();
        Node head=generateNodeByString(nodes[index++]);
        queue.offer(head);
        Node node=null;
        while (!queue.isEmpty()){
            node=queue.poll();
            node.left=generateNodeByString(nodes[index++]);
            node.right=generateNodeByString(nodes[index++]);
            if (node.left !=null){
                queue.offer(node.left);
            }
            if (node.right!=null){
                queue.offer(node.right);
            }
        }
        return head;
    }
    //根据字符串来创建对应的节点
    private static Node generateNodeByString(String data) {
        if (data.equals("#")){
            return null;
        }
        return new Node(Integer.valueOf(data));
    }
}
