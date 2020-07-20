package linkedList;
/**
  实现双向链表的功能
*/
public class DoubleLinkedListDemo {
    //头结点不存放具体数据，用于连接
    private HeroNode2 head=new HeroNode2(0,"","");
    public HeroNode2 getHead() {
        return head;
    }
    //向双向链表中添加元素
    public void add(HeroNode2 node){
        HeroNode2 temp=head;
        //将temp移动到最后一个节点
        while (temp.next !=null){
            temp=temp.next;
        }
        //将添加的节点进行连接
        temp.next=node;
        node.pre=temp;
    }
    //根据num修改节点信息
    public void update(HeroNode2 heroNode){
        //temp为头结点的下一个节点,flag为是否需要修改的标志位
        HeroNode2 temp=head.next;
        boolean flag= false;
        while (true){
            //没有找到
            if (temp == null){
                break;
            }
            if (temp.num == heroNode.num){
                //找到了
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.name=heroNode.name;
            temp.nickName=heroNode.nickName;
        }else {
            System.out.println("没有找到，修改失败");
        }
    }
    //删除一个节点
    public void delete(HeroNode2 heroNode){
        HeroNode2 temp=head;
        boolean flag=false;
        while (true){
            if (temp.next ==null){
                break;
            }
            if (temp.next.num ==heroNode.num){
                //找到了
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            temp.pre.next=temp.next;
            temp.next.pre=temp.pre;
        }else {
            System.out.println("没有找到需要删除的那个节点~");
        }
    }
}
//水浒传英雄节点类
class HeroNode2{
    int num;
    String name;
    String nickName;
    HeroNode2 next;
    HeroNode2 pre;
    public HeroNode2(int num, String name, String nickName) {
        this.num = num;
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "num=" + num +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}