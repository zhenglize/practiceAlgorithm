package greedy;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
*@author zhenglize
输入： 参数1，正数数组costs 参数2，正数数组profits 参数3，正数k 轮数 参数4，正数m 本金
costs[i]表示i号项目的花费 profits[i]表示i号项目在扣除花费之后还能挣到的钱(利润) k表示你不能并行、
只能串行的最多做k个项目 m表示你初始的资金
说明：你每做完一个项目，马上获得的收益，可以支持你去做下一个项目。
输出： 你最后获得的最大钱数。
*/
public class IPO {
    //节点的值为花费和利润
    public static class Node{
        int cost;
        int profit;
        public Node(int cost,int profit){
            this.cost=cost;
            this.profit=profit;
        }
    }
    //按照花费数目的大小形成小根堆
    public static class MinCostComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o1.cost-o2.cost;
        }
    }
    //按照利润的大小形成小根堆
    public static class MaxProfitComparator implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            return o2.profit-o1.profit;
        }
    }
    /**
     @param costs 花费数组
     @param profits 利润数组
     @param M 本金钱数
     @param K 一共可以进行多少轮
    */
    public static int findMatrixMoney(int[] costs ,int[] profits , int M ,int K){
        Node[] node=new Node[costs.length+1];
        //将本金和利润生成节点类型的值
        for (int i = 0; i < costs.length; i++) {
            node[i]=new Node(costs[i],profits[i]);
        }
        PriorityQueue<Node> minCostQueue=new PriorityQueue<>(new MinCostComparator());
        PriorityQueue<Node> maxProfitQueue=new PriorityQueue<>(new MaxProfitComparator());
        for (int i = 0; i < node.length; i++) {
            minCostQueue.add(node[i]);
        }
        for (int i = 0; i < K; i++) {
            while (!minCostQueue.isEmpty() && minCostQueue.peek().cost <= M){
                maxProfitQueue.add(minCostQueue.poll());
            }
            if (maxProfitQueue.isEmpty()){
                return M;
            }
            M+=maxProfitQueue.poll().profit;
        }
        return M;
    }
}
