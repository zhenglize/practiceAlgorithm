package linkedList;

import java.util.Stack;

/**
*@author zhenglize
  实现单链表的功能，模拟水浒传英雄排序
*/
public class SingleLinkedList {
    //头结点不存放具体数据，用于连接
    private HeroNode head=new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    //向单链表中添加元素
    public void add(HeroNode node){
        HeroNode temp=head;
        //将temp移动到最后一个节点
        while (temp.next !=null){
            temp=temp.next;
        }
        //将添加的节点进行连接
        temp.next=node;
    }
    public void addByNum(HeroNode hero){
        //此时的temp在比较的时候，需要比较的是它下一个节点
        HeroNode temp=head;
        //判断是否为重复的标志位
        boolean flag=false;
        while (true){
            //已经到了最后一个节点退出循环
            if (temp.next == null){
                break;
            }
            //之所以使用next的num是因为保证当前的temp的next就是要插入的hero
            if (temp.next.num > hero.num){
                break;
            }else if (temp.next.num == hero.num){
                flag=true;
                break;
            }
            temp=temp.next;
        }
        if (flag){
            System.out.println("该英雄已经添加过了~");
        }else {
            //将hero连接到链表中
            hero.next=temp.next;
            temp.next=hero;
        }
    }
    //根据num修改节点信息
    public void update(HeroNode heroNode){
        //temp为头结点的下一个节点,flag为是否需要修改的标志位
        HeroNode temp=head.next;
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
    public void delete(HeroNode heroNode){
        HeroNode temp=head;
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
            temp.next=temp.next.next;
        }else {
            System.out.println("没有找到需要删除的那个节点~");
        }
    }
    //返回单链表中的结点个数
    public static int getLength(HeroNode head){
        if (head.next ==null){
            return 0;
        }
        int len=0;
        HeroNode help=head.next;
        while (help !=null){
            len++;
            help=help.next;
        }
        return len;
    }
    //逆序打印一个链表
    public  void printLinkedListReverse(HeroNode head){
        if (head.next ==null){
            return;
        }
        Stack<HeroNode> stack=new Stack<>();
        HeroNode cur=head.next;
        while (cur != null){
            stack.add(cur);
            cur=cur.next;
        }
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }
    //打印链表中的数据
    public void list(){
        if (head ==null){
            System.out.println("链表为空");
        }
        //声明为头结点的下一个节点
        HeroNode node=head.next;
        while (node !=null){
            System.out.println(node);
            node=node.next;
        }
    }
    //合并两个有序的单链表，要求合并之后依然有序,返回合并后有序链表的头结点
    public static HeroNode sort(HeroNode head1 , HeroNode head2){
        //对特殊情况的判断
        if (head1 == null && head2 ==null){
            return null;
        }
        if (head1 ==null){
            return head2;
        }
        if (head2==null){
            return head1;
        }
        HeroNode resNode=new HeroNode(0,"","");
        HeroNode cur=resNode;
        HeroNode help=null;
        HeroNode cur1=head1;
        HeroNode cur2=head2;
        while (cur1 !=null && cur2 !=null){
            if (cur1.num < cur2.num){
                help=cur1;
                cur1=cur1.next;
            }else {
                help=cur2;
                cur2=cur2.next;
            }
            cur.next=help;
            cur=help;
        }
        while (cur1 !=null){
            help=cur1;
            cur1=cur1.next;
            cur.next=help;
            cur=help;
        }
        while (cur2 !=null){
            help=cur2;
            cur2=cur2.next;
            cur.next=help;
            cur=help;
        }
        return resNode;
    }

    /**
     寻找一个链表的倒数第k个节点
      @param head 头结点
     @param index 寻找倒数第index位置的节点
     */
    public static HeroNode getLastIndexNode(HeroNode head, int index){
        if (head.next ==null){
            return null;
        }
        //查看该链表的长度
        int size =getLength(head);
        //对index的值进行判断
        if (index <0 || index >size){
            return null;
        }
        //通过for循环进行节点的寻找
        HeroNode node=head.next;
        for (int i = 0; i < size - index; i++) {
            node=node.next;
        }
        return node;
    }
    //反转单向链表
    public static HeroNode reverseList(HeroNode head){
         //由于头部是没有用的，所以两个节点不需要反转
        if (head.next ==null){
            return null;
        }
        //next记录的是cur的下一个节点
        HeroNode next=null;
        HeroNode pre=null;
        while (head !=null){
            //将下一个节点保存
            next=head.next;
            //head右移
            head.next=pre;
            //交换
            pre=head;
            head=next;
        }
        return pre;
    }

    public static void main(String[] args) {
      /*  HeroNode heroNode1=new HeroNode(1,"宋江","及时雨");
        HeroNode heroNode2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode heroNode3=new HeroNode(3,"吴用","智多星");
        SingleLinkedList list=new SingleLinkedList();
        list.addByNum(heroNode1);
        list.addByNum(heroNode2);
        list.addByNum(heroNode3);
        list.list();
        System.out.println();
        //重读添加，添加失败
        list.addByNum(heroNode1);
        list.list();
        System.out.println();
        HeroNode heroNode4=new HeroNode(13,"鲁智深","花和尚");
        HeroNode heroNode5=new HeroNode(6,"林冲","豹子头");
        list.addByNum(heroNode4);
        list.addByNum(heroNode5);
        list.list();
        System.out.println();
        HeroNode newHeroNode3=new HeroNode(3,"无用","扫把星");
        list.update(newHeroNode3);
        list.list();
        System.out.println();
        list.delete(heroNode3);
        list.list();
        System.out.println();
        System.out.println("该链表中的有效节点个数为:"+
                SingleLinkedList.getLength(list.getHead()));
        System.out.println();
        System.out.println("该链表的倒数第一个节点是:"+
                SingleLinkedList.getLastIndexNode(list.getHead(),1));
        System.out.println();
       *//* HeroNode node = SingleLinkedList.reverseList(list.getHead());
        while (node !=null){
            System.out.print(node+" ");
            node=node.next;
        }*//*
        list.printLinkedListReverse(list.getHead());*/
        HeroNode heroNode1=new HeroNode(55,"a","a");
        heroNode1.next=new HeroNode(65,"b","c");
         heroNode1.next.next=new HeroNode(80,"c","c");
         HeroNode heroNode2=new HeroNode(66,"d","d");
         heroNode2.next=new HeroNode(70,"d","d");
        HeroNode heroNode = SingleLinkedList.sort(heroNode1, heroNode2);
        while (heroNode !=null){
            System.out.println(heroNode);
            heroNode=heroNode.next;
        }
    }
}
//水浒传英雄节点类
class HeroNode{
    int num;
    String name;
    String nickName;
    HeroNode next;
    public HeroNode(int num, String name, String nickName) {
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