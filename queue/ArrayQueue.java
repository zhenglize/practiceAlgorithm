package queue;
/**
*使用数组实现一个队列结构
 * 使用size变量实现了start和end的解耦
 *
*/
public class ArrayQueue {
    int[] queue;
    int start;
    int size;
    int end;
    public ArrayQueue(int initSize){
        queue=new int[initSize];
        start=0;
        end=0;
        size=0;
    }
    //查看队列头部的元素
    public int peek(){
        if (size == 0)
            throw new ArrayIndexOutOfBoundsException("queue is empty");
        return queue[start];
    }
    //向队列中添加一个元素
    public void add(int value){
        if (size==queue.length)
            throw new ArrayIndexOutOfBoundsException("queue is full");
        size++;
        queue[end]=value;
        //若等于队列长度队列回到头位置，如果没满则直接+1
        end=end==queue.length-1 ? 0 :end+1;
    }
    //删除队列中的一个元素
     public int poll(){
         if (size == 0)
             throw new ArrayIndexOutOfBoundsException("queue is empty");
         size--;
         int res=queue[start];
         start=start==queue.length-1 ? 0 : start+1;
         return res;
     }

    public static void main(String[] args) {
        ArrayQueue queue=new ArrayQueue(3);
        queue.add(1);
        queue.add(2);
        queue.add(2);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        //print 1  1
    }
}
