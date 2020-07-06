package UnionFindSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
*@author zhenglize
 并查集:
 有两个方法一个是isSameSet，给出两个节点判断他们是否在一个并查集中。实现思路是找到其所在节点的父节点，
 若它们的父节点相同，则是一个并查集，不相同则不是一个并查集。
 另一个方法是Union合并两个并查集，判断并查集的大小，将size小的那个合并到size大的那个并查集中
*/
public class UnionFindSet {
    public static class Node{}
    private Map<Node,Node> fatherMap; //key :当前节点 value: 当前节点的父节点
    private Map<Node,Integer> sizeMap; //key:当前节点  value:当前节点所在的并查集的大小
    //必须初始给定并查集的元素，一旦创建不允许中途修改
    public UnionFindSet(List<Node> nodes){
        makeSet(nodes);
    }

    private void makeSet(List<Node> nodes) {
        fatherMap=new HashMap<>();
        sizeMap=new HashMap<>();
        //将集合中的元素生成并查集，每个元素的父结点为自己，size为1
        for (Node node:nodes){
            fatherMap.put(node,node);
            sizeMap.put(node,1);
        }
    }
    //找到元素的父节点，并进行优化，将并查集变的扁平
    private Node findFather(Node node){
        Stack<Node> stack=new Stack<>();
        Node cur=node;
        Node parent=fatherMap.get(node);
        while (cur !=parent){
            stack.push(cur);
            cur=parent;
            parent=fatherMap.get(cur);
        }
        while (!stack.isEmpty()){
            fatherMap.put(stack.pop(),parent);
        }
        return parent;
    }
    //判断两个节点是否在一个并查集
    public boolean isSameSet(Node a,Node b){
        return findFather(a) == findFather(b);
    }
    //合并两个集合
    public void union(Node a,Node b){
        if (a==null || b==null){
            return;
        }
        Node headA = findFather(a);
        Node headB = findFather(b);
        if (headA !=headB){
            Integer countA = sizeMap.get(headA);
            Integer countB = sizeMap.get(headB);
            if (countA >=countB){
                fatherMap.put(headB,headA);
                sizeMap.put(headA,countA+countB);
            }else {
                fatherMap.put(headA,headB);
                sizeMap.put(headB,countA+countB);
            }
        }
    }
}
