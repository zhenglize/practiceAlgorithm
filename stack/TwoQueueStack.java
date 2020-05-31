package stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhenglize
*使用两个队列实现一个栈
 解题思路:
 使用两个队列
 pop操作的时候将数据导入另一个空队列中，弹出最后一个元素，之后交换他们的引用
*/

public class TwoQueueStack {
   private  Queue<Integer> data;
   private  Queue<Integer> help;
   public TwoQueueStack(){
       data=new LinkedList<>();
       help=new LinkedList<>();
   }
   //向栈中添加元素
    public void push(int value){
       data.add(value);
    }
    //弹出栈顶的元素
    public int pop(){
       if (data.isEmpty())
           throw new RuntimeException("queue is empty");
       while (data.size()!=1){
           //数据拷贝至help数组
           help.add(data.poll());
       }
       int res=data.poll();
       swap();
       return res;
    }
    //查看栈顶的元素
    public int peek(){
        if (data.isEmpty())
            throw new RuntimeException("queue is empty");
        while (data.size()!=1){
            //数据拷贝至help数组
            help.add(data.poll());
        }
        int res=data.poll();
        help.add(res);
        swap();
        return res;
    }
    //交换两个队列的引用
    public  void swap(){
       Queue<Integer> queue=data;
       data=help;
       help=queue;
    }

    public static void main(String[] args) {
        TwoQueueStack stack=new TwoQueueStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }
}
