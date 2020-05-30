package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
*@author zhenglize
 * 工程中的排序算法:
 * 如果是八种基础数据类型会使用快排。因为基础类型，相同的值无差异
 * 如果是对象中的字段进行排序，会使用归并排序。因为需要保证其稳定性
 * 如果数组长度很短，会直接使用插排。（数组长度小于60）。
 * 因为插排的常数项很低，在小样本的情况下，插排O(n^2)的劣势表现不出来
*/
public class comparator {
    public static void main(String[] args) {
        Student s1=new Student(1,2,"小明");
        Student s2=new Student(2,3,"小红");
        Student s3=new Student(3,4,"小花");
        Student[] students={s1,s2,s3};
        Arrays.sort(students,new IdComparator());
        printStudents(students);
        System.out.println("=================");
        System.out.println("=================");
        System.out.println("=================");
        Arrays.sort(students,new AgeComparator());
        printStudents(students);
        System.out.println("=================");
        System.out.println("=================");
        System.out.println("=================");
        //堆中使用比较器（优先级队列）
        PriorityQueue<Student> heap=new PriorityQueue<>(new IdComparator());
        heap.add(s1);
        heap.add(s2);
        heap.add(s3);
        while (!heap.isEmpty()){
            Student student=heap.poll();
            System.out.println(student);
        }
        System.out.println("=================");
        System.out.println("=================");
        System.out.println("=================");
        //TreeSet 或者 TreeMap中使用比较器
        TreeSet<Student> set=new TreeSet<>(new AgeComparator());
        set.add(s1);
        set.add(s2);
        set.add(s3);
        while (!set.isEmpty()){
            Student student=set.pollFirst();
            System.out.println(student);
        }
        /**
        *print :
         Student{id=1, age=2, name='小明'}
         Student{id=2, age=3, name='小红'}
         Student{id=3, age=4, name='小花'}
         =================
         =================
         =================
         Student{id=3, age=4, name='小花'}
         Student{id=2, age=3, name='小红'}
         Student{id=1, age=2, name='小明'}
         =================
         =================
         =================
         Student{id=1, age=2, name='小明'}
         Student{id=2, age=3, name='小红'}
         Student{id=3, age=4, name='小花'}
         =================
         =================
         =================
         Student{id=3, age=4, name='小花'}
         Student{id=2, age=3, name='小红'}
         Student{id=1, age=2, name='小明'}
        */
    }
    public static void printStudents(Student[] s1){
        for (int i = 0; i < s1.length; i++) {
            System.out.println(s1[i]);
        }
    }
}
class Student{
    int id;
    int age;
    String name;

    public Student(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
//自定义比较器，需要实现compare方法
class IdComparator implements Comparator<Student>{
    //若返回负数 ，则从小到大升序排列
    @Override
    public int compare(Student o1, Student o2) {
        return o1.id-o2.id;
    }
}
class AgeComparator implements Comparator<Student>{
    //若返回负数 ，则从大到小降序排列
    @Override
    public int compare(Student o1, Student o2) {
        return o2.age-o1.age;
    }
}