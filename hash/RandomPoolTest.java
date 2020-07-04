package hash;

import java.util.HashMap;
import java.util.Map;

/**
*@author zhenglize
设计RandomPool结构
【题目】 设计一种结构，在该结构中有如下三个功能：
insert(key)：将某个key加入到该结构，做到不重复加入。
delete(key)：将原本在结构中的某个key移除。 getRandom()：
等概率随机返回结构中的任何一个key。
【要求】 Insert、delete和getRandom方法的时间复杂度都是O(1)
*/
public class RandomPoolTest {
    public static class RandomPool<K>{
        Map<K,Integer> keyIndex;
        Map<Integer,K> indexKey;
        int size;
        public RandomPool(){
            keyIndex=new HashMap<>();
            indexKey=new HashMap<>();
            size=0;
        }
        /**
         insert(key)：将某个key加入到该结构，做到不重复加入。
        */
        public void insert(K key){
            if (!keyIndex.containsKey(key)){
                keyIndex.put(key,size);
                indexKey.put(size,key);
                size++;
            }
        }
        /**
         等概率随机返回结构中的任何一个key。
        */
        public K getRandom(){
            if (size == 0){
                return null;
            }
            int index= (int) (Math.random()*size);
            return indexKey.get(index);
        }
        /**
         delete(key)：将原本在结构中的某个key移除。
         */
        public void delete(K key){
            if (keyIndex.containsKey(key)){
                //将当前的key与最后一个位置进行交换，同时删除最后一个位置的元素，size--
                int index=keyIndex.get(key);
                int lastIndex=--size;
                //拿到最后一个元素的值
                K lastData=indexKey.get(lastIndex);
                //将值添加到两个map中
                keyIndex.put(lastData,index);
                indexKey.put(lastIndex,key);
                //删除元素
                keyIndex.remove(key);
                indexKey.remove(lastIndex);
            }
        }
    }

    public static void main(String[] args) {
        RandomPool<String> pool=new RandomPool<>();
        pool.insert("zheng");
        pool.insert("li");
        pool.insert("ze");
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
        System.out.println(pool.getRandom());
    }

}
