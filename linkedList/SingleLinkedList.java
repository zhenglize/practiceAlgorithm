package linkedList;
/**
*@author zhenglize
  实现单链表的功能，模拟水浒传英雄排序
*/
public class SingleLinkedList {
    //头结点不存放具体数据，用于连接
    private HeroNode head=new HeroNode(0,"","");
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

    public static void main(String[] args) {
        HeroNode heroNode1=new HeroNode(1,"宋江","及时雨");
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