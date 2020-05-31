package queue;

import java.util.LinkedList;
import java.util.Queue;

/**
*@author zhenglize
猫狗队列 【题目】 宠物、狗和猫的类如下：
public class Pet { private String type;
public Pet(String type) { this.type = type; }
public String getPetType() { return this.type; }
}
public class Dog extends Pet { public Dog() { super("dog"); } }
public class Cat extends Pet { public Cat() { super("cat"); } }
实现一种狗猫队列的结构，要求如下： 用户可以调用add方法将cat类或dog类的
实例放入队列中； 用户可以调用pollAll方法，将队列中所有的实例按照进队列
的先后顺序依次弹出； 用户可以调用pollDog方法，将队列中dog类的实例按照
进队列的先后顺序依次弹出； 用户可以调用pollCat方法，将队列中cat类的实
例按照进队列的先后顺序依次弹出； 用户可以调用isEmpty方法，检查队列中是
否还有dog或cat的实例； 用户可以调用isDogEmpty方法，检查队列中是否有dog
类的实例； 用户可以调用isCatEmpty方法，检查队列中是否有cat类的实例。

 解题思路
 对pet进行封装，添加一个时间戳，根据时间戳来判断进队列的顺序
*/
public class DogCatQueue {
    public static class Pet {
        private String type;

        public Pet(String type) {
            this.type = type;
        }

        public String getPetType() {
            return this.type;
        }
    }

    public static class Dog extends Pet {
        public Dog() {
            super("dog");
        }
    }

    public static class Cat extends Pet {
        public Cat() {
            super("cat");
        }
    }
    //1.设计一个具有时间戳的类
    public static class PetEnter {
        Pet pet;
        long count;

        public PetEnter(Pet pet, long count) {
            this.pet = pet;
            this.count = count;
        }

        public Pet getPet() {
            return pet;
        }

        public long getCount() {
            return count;
        }
        public String getPetType(){
            return pet.getPetType();
        }
    }
    public static class MyQueue{
        Queue<PetEnter> dog;
        Queue<PetEnter> cat;
        long count;

        public MyQueue() {
            dog=new LinkedList<>();
            cat=new LinkedList<>();
            count=0;
        }
        /**
        *向猫狗队列中添加宠物
        */
        public void add(Pet pet){
            if (pet.getPetType().equals("dog")){
                dog.add(new PetEnter(pet,count++));
            }else if (pet.getPetType().equals("cat")){
                cat.add(new PetEnter(pet,count++));
            }else {
                throw new RuntimeException("neither dog or cat");
            }
        }
        /**
        * 弹出最先插入的狗
        */
        public Dog pollDog(){
            if (dog.isEmpty()){
                throw new RuntimeException("dog is empty");
            }
            return (Dog) dog.poll().getPet();
        }
        /**
         * 弹出最先插入的猫
         */
        public Cat pollCat(){
            if (cat.isEmpty()){
                throw new RuntimeException("cat is empty");
            }
            return (Cat) cat.poll().getPet();
        }
        /**
        *弹出猫狗队列中先进去的那个
        */
        public Pet pollAll() {
            if (!dog.isEmpty() && !cat.isEmpty()){
                if (dog.peek().getCount() < cat.peek().getCount()){
                    return (Dog)dog.poll().getPet();
                }else {
                    return (Cat)cat.poll().getPet();
                }
            }else if (!dog.isEmpty()) {
                return (Dog)dog.poll().getPet();
            } else if (!cat.isEmpty()){
                return (Cat)cat.poll().getPet();
            }else {
                throw new RuntimeException("both queue are empty");
            }
        }
        /**
         *判断狗队列是否为空
         */
        public boolean isDogEmpty(){
            return dog.isEmpty();
        }
        /**
         *判断狗队列是否为空
         */
        public boolean isCatEmpty(){
            return cat.isEmpty();
        }
        /**
        *判断两个队列是否为空
        */
        public boolean isEmpty(){
            return cat.isEmpty() && dog.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue test = new MyQueue();

        Pet dog1 = new Dog();
        Pet cat1 = new Cat();
        Pet dog2 = new Dog();
        Pet cat2 = new Cat();
        Pet dog3 = new Dog();
        Pet cat3 = new Cat();

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);

        test.add(dog1);
        test.add(cat1);
        test.add(dog2);
        test.add(cat2);
        test.add(dog3);
        test.add(cat3);
        while (!test.isDogEmpty()) {
            System.out.println(test.pollDog().getPetType());
        }
        while (!test.isEmpty()) {
            System.out.println(test.pollAll().getPetType());
        }
        //print dog
        //dog
        //dog
        //dog
        //dog
        //dog
        //dog
        //dog
        //dog
        //cat
        //cat
        //cat
        //cat
        //cat
        //cat
        //cat
        //cat
        //cat
    }
    }

