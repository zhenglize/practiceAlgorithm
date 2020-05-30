package stack;
/**
*用数组实现一个栈
*/
public class ArrayStack {
    int[] stack;
    int index;
    public ArrayStack(int initSize){
        if (initSize < 0){
            throw new IllegalArgumentException("size less 0");
        }
        stack=new int[initSize];
        index=0;
    }
    //返回栈顶的值
    public int peek(){
        if (index ==0){
            throw new IllegalArgumentException("stack is empty");
        }
        //index是当前空的位置，所以索引要下滑一个
        return stack[index-1];
    }
    //向栈中添加一个元素
    public void add(int value){
        if (index > stack.length){
            throw new IllegalArgumentException("stack is full");
        }
        stack[index++]=value;
    }
    //弹出栈中的一个元素
    public int poll(){
        if (index ==0){
            throw new IllegalArgumentException("stack is empty");
        }
        return stack[--index];
    }

    public static void main(String[] args) {
        ArrayStack stack=new ArrayStack(3);
        stack.add(1);
        stack.add(2);
       // stack.add(3);
        System.out.println(stack.peek());
    }
}
