package stack;

import java.util.Stack;

/**
 *实现一个特殊的栈，在实现栈的基本功能的基础上，再实现返
 * 回栈中最小元素的操作。
 * 【要求】
 * 1．pop、push、getMin操作的时间复杂度都是O(1)。
 * 2．设计的栈类型可以使用现成的栈结构。
 *
 * 解题思路:
 * 设计两个栈，一个data栈，一个min栈，当添加元素的时候，向data添加，同时比对min栈的头位置，如果大于，则重复压入
 * min栈的头位置，小于的话则把小于头位置的这个数字压入min栈
 */
public class getMinStack {
    Stack<Integer> data;
    Stack<Integer> min;
    public getMinStack(){
        data=new Stack<>();
        min=new Stack<>();
    }
    //向添加栈中添加元素的方法
    public void push(int value){
        //如果min是空的，直接添加元素到栈中。若不是比较大小，栈中的数字小则重新添加头位置，
        // 栈中的数大，则把这个数字添加到栈中
        if (min.isEmpty()){
            min.push(value);
        } else if (this.getMin() < value){
            min.push(min.peek());
        }else {
            min.push(value);
        }
        data.push(value);
    }
    //删除栈中的元素
    public int pop(){
        if (data.isEmpty())
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        min.pop();
        return data.pop();
    }
    //返回栈中最小的元素
    public int getMin(){
        if (min.isEmpty())
            throw new ArrayIndexOutOfBoundsException("stack is empty");
        return min.peek();
    }

    public static void main(String[] args) {
        getMinStack stack=new getMinStack();
        stack.push(53);
        stack.push(13);
        stack.push(34);
        System.out.println(stack.getMin());

    }
}
