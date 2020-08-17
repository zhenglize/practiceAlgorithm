package hash;

import java.util.*;

/**
*@author zhenglize
  将HashMap<Inteeger,User>按照age属性进行倒序排列
*/
public class HashMapSort {
    public static void main(String[] args) {
        HashMap<Integer,User> hashMap=new HashMap<>();

        User user1=new User();
        user1.setName("张三");
        user1.setAge(18);

        User user2=new User();
        user2.setName("李四");
        user2.setAge(23);

        User user3=new User();
        user3.setName("王五");
        user3.setAge(6);

        hashMap.put(1,user1);
        hashMap.put(2,user2);
        hashMap.put(3,user3);

        HashMap<Integer,User> hashMap1= sortByAge(hashMap);
        Set<Map.Entry<Integer, User>> entries = hashMap1.entrySet();
        for (Map.Entry<Integer, User> user:entries) {
            System.out.println(user);
        }
    }

    private static HashMap<Integer, User> sortByAge(HashMap<Integer, User> hashMap) {
        //由于linkedHashMap可以保证插入的顺序性，所以返回linkedHashMap
        LinkedHashMap<Integer,User> linkedHashMap=new LinkedHashMap<>();
        //将map -> set 因为sort方法接收的类型为list
        Set<Map.Entry<Integer, User>> entries = hashMap.entrySet();
        // set -> list list的构造方法传递一个collections转化为一个list
        ArrayList<Map.Entry<Integer, User>> list = new ArrayList<>(entries);
        //使用匿名内部类自定义一个排序器，进行排序
        Collections.sort(list, new Comparator<Map.Entry<Integer, User>>() {
            @Override
            public int compare(Map.Entry<Integer, User> o1, Map.Entry<Integer, User> o2) {
                return o2.getValue().getAge()-o1.getValue().getAge();
            }
        });
        //将list放入linkedMap中
        for (int i = 0; i < list.size(); i++) {
            Map.Entry<Integer, User> entry = list.get(i);
            linkedHashMap.put(entry.getKey(),entry.getValue());
        }
        return linkedHashMap;
    }
}
class User{
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}