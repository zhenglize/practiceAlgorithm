package hash;

public class HashMapImpl {
    public static void main(String[] args) {
        hashTab tab=new hashTab(10);
        tab.add(new Emp(1,"a"));
        tab.add(new Emp(2,"b"));
        tab.add(new Emp(3,"c"));
        tab.list();
        System.out.println();
        System.out.println(tab.find(1));
        System.out.println();
        System.out.println(tab.remove(1));
        System.out.println();
        tab.list();
    }
}
class hashTab{
    EmpLinkedList[] hashList;
    int size;
    public hashTab(int size){
        this.size=size;
        hashList=new EmpLinkedList[size];
        //给数组中每个链表赋值
        for (int i = 0; i < size; i++) {
            hashList[i]=new EmpLinkedList();
        }
    }
    //向哈希表中添加元素
    public void add(Emp emp){
        int bucket = hashRam(emp.id);
        hashList[bucket].add(emp);
    }
    //遍历哈希表中的元素
    public void list(){
        for (int i = 0; i < size; i++) {
            hashList[i].list();
        }
    }
    //根据id查找雇员
    public Emp find(int id){
        int bucket = hashRam(id);
        //查找的、在几号桶，接着查找雇员
        Emp emp = hashList[bucket].findEmpById(id);
        return emp;
    }
    //查看哈希值
    public int hashRam(int id){
        return id %size;
    }
    public boolean remove(int id){
        int bucket=hashRam(id);
        boolean flag = hashList[bucket].remove(id);
        if (flag){
            System.out.println("删除成功");
            return true;
        }else {
            System.out.println("删除失败");
            return false;
        }
    }
}
class EmpLinkedList{
    Emp head;
    //向链表中添加节点
    public void add(Emp emp){
        if (head == null){
            head=emp;
            return;
        }
        //寻找到最后一个节点
        Emp cur=head;
        while (cur.next !=null){
            cur=cur.next;
        }
        cur.next=emp;
    }
    //遍历链表中的节点
    public void list(){
        if (head ==null){
            System.out.println("您要遍历的链表为空");
            return;
        }
        Emp cur=head;
        while (cur!=null){
            System.out.println(cur);
            cur=cur.next;
        }
    }
    //根据id查找雇员
    public Emp findEmpById(int id){
        if (head ==null){
            return null;
        }
        Emp cur=head;
        while (cur !=null){
            if (cur.id == id){
                break;
            }
            cur=cur.next;
        }
        return cur;
    }
    //根绝id删除链表中的雇员
    public boolean remove(int id){
        if (head ==null){
            return false;
        }
        Emp cur=head;
        if (cur.id ==id){
            if (cur.next!=null){
                head=cur.next;
            }else {
                head=null;
            }
            System.out.println("删除成功");
            return true;
        }
        boolean flag=false;
        while (cur.next !=null){
            if (cur.next.id ==id){
                flag=true;
                if (cur.next.next !=null){
                    cur.next=cur.next.next;
                }else {
                    cur.next=null;
                }
                break;
            }
            cur=cur.next;
        }

       return flag;
    }
}
class Emp{
    int id;
    String name;
    Emp next;
    public Emp(int id ,String name){
        this.id=id;
        this.name=name;
    }
    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
