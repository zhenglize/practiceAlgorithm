package tree;
/**
*@author zhenglize
 手写实现前缀树
*/
public class TrieTree {
    public static class TrieNode{
        int path;
        int end;
        TrieNode[] nexts;
        //path为节点经过的半径，end为以该节点为终点的节点数目，nexts为下面有多少条路
        public TrieNode(){
            path=0;
            end=0;
            nexts=new TrieNode[26];
        }
    }
    TrieNode root;
    public TrieTree(){
        root=new TrieNode();
    }
    //插入字符串
    public void insert(String str){
        if (str == null){
            return;
        }
        char[] arr=str.toCharArray();
        int index=0;
        TrieNode node=root;
        for (int i = 0; i < arr.length; i++) {
             index=arr[i]-'a';
            if (node.nexts[index] ==null){
                node.nexts[index]=new TrieNode();
            }
            node=node.nexts[index];
            node.path++;
        }
        node.end++;
    }
    //寻找以该字符串结尾的个数
    public int search(String str){
        if (str == null){
            return 0;
        }
        char[] arr=str.toCharArray();
        int index;
        TrieNode node=root;
        for (int i = 0; i < arr.length; i++) {
            index=arr[i] -'a';
            if (node.nexts[index] ==null){
                return 0;
            }
              node= node.nexts[index];
        }
        return node.end;
    }
    //删除某一字符串
    public void delete(String str){
        if (str==null)
            return;
        if (search(str) !=0){
            char[] arr=str.toCharArray();
            int index=0;
            TrieNode node=root;
            for (int i = 0; i < arr.length; i++) {
                index=arr[i] -'a';
                if (--node.nexts[index].path ==0){
                    node.nexts[index]=null;
                    return;
                }
                node=node.nexts[index];
            }
        }
    }
    //宣召前缀词频
    public int PrefixNumber(String pre){
        if (pre ==null)
             return 0;
        char[] arr=pre.toCharArray();
        int index=0;
        TrieNode node=root;
        for (int i = 0; i < arr.length; i++) {
            index=arr[i] -'a';
            if (node.nexts[index] ==null){
                return 0;
            }
            node=node.nexts[index];
        }
        return node.path;
    }
}
