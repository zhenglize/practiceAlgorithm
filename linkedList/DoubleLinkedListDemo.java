package linkedList;
/**
  实现双向链表的功能
*/
public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        HeroNode2 heroNode1=new HeroNode2(1,"宋江","及时雨");
        HeroNode2 heroNode2=new HeroNode2(2,"卢俊义","玉麒麟");
        HeroNode2 heroNode3=new HeroNode2(3,"吴用","智多星");
        HeroNode2 heroNode4=new HeroNode2(4,"林冲","豹子头");
        DoubleLinkedListDemo linkedListDemo=new DoubleLinkedListDemo();
      /*  linkedListDemo.add(heroNode1);
        linkedListDemo.add(heroNode2);
        linkedListDemo.add(heroNode3);
        linkedListDemo.add(heroNode4);
        System.out.println("向双向链表中添加节点");
        linkedListDemo.list();

        System.out.println("修改链表中的节点");
        HeroNode2 heroNode5=new HeroNode2(4,"公孙胜","入云龙");
        linkedListDemo.update(heroNode5);
        linkedListDemo.list();

        System.out.println("删除双向链表中的节点");
        linkedListDemo.delete(3);
        linkedListDemo.list();*/
        System.out.println("根据顺序插入节点");
        linkedListDemo.addByNum(heroNode3);
        linkedListDemo.addByNum(heroNode1);
        linkedListDemo.addByNum(heroNode2);
        linkedListDemo.addByNum(heroNode4);
        HeroNode2 heroNode6=new HeroNode2(6,"吴用","智多星");
        HeroNode2 heroNode7=new HeroNode2(5,"林冲","豹子头");
        linkedListDemo.addByNum(heroNode6);
        linkedListDemo.addByNum(heroNode7);
        linkedListDemo.list();
    }
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
    public void delete(int num){
        HeroNode2 temp=head;
        boolean flag=false;
        while (true){
            if (temp.next ==null){
                break;
            }
            if (temp.num ==num){
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
    public void list(){
        if (head.next ==null){
            return;
        }
        HeroNode2 cur=head.next;
        while (cur!=null){
            System.out.println(cur+" ");
            cur=cur.next;
        }
    }
    //根据编号添加英雄
    public void addByNum(HeroNode2 heroNode2){
        HeroNode2 cur=head;
        boolean flag=false;
        while (true){
            if (cur.next == null){
                break;
            }
            if (cur.next.num > heroNode2.num){
                break;
            }else if (cur.next.num ==heroNode2.num){
                flag=true;
                break;
            }
            cur=cur.next;
        }
        if (flag){
            System.out.println("该节点已经添加过了~");
        }else {
                heroNode2.pre=cur;
                heroNode2.next=cur.next;
                cur.next=heroNode2;
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