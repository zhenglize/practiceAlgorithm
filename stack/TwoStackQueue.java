package stack;

import java.util.Stack;

/**
*@author zhenglize
 用两个栈实现一个队列结构
 解题思路:准备两个栈
  一个push栈，用来添加元素，一个pop栈删除元素
  倒数据的过程中要遵守两个原则:
   如果pop队列不是空的不能倒
 push队列的数据一次必须全部倒完
*/
public class TwoStackQueue {
    Stack<Integer> pushStack;
    Stack<Integer> popStack;
    public TwoStackQueue(){
        pushStack=new Stack<>();
        popStack=new Stack<>();
    }
    //倒数据遵守两个原则
    public void dao(){
        if (!popStack.isEmpty()){
            return;
        }
        while (!pushStack.isEmpty()){
            popStack.push(pushStack.pop());
        }
    }
    //向队列中添加数据,如果pop栈空了，则倒数据
    public void push(int value){
        pushStack.push(value);
        dao();
    }
    //删除队列中的元素
    public int pop(){
        if (popStack.isEmpty() && pushStack.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("queue is empty");
        }
        dao();
        return popStack.pop();
    }
    //查看队列头部的元素
    public int peek(){
        if (popStack.isEmpty() && pushStack.isEmpty()){
            throw new ArrayIndexOutOfBoundsException("queue is empty");
        }
        dao();
        return popStack.peek();
    }

    public static void main(String[] args) {
        TwoStackQueue queue=new TwoStackQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.peek());
    }
}
