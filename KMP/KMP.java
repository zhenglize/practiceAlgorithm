package KMP;
/**
*@author zhenglize
 手写实现KMP算法
*/
public class KMP {
    public static int getIndexOf(String str1,String str2){
        if (str1 == null || str2 ==null || str1.length() <str2.length()){
            return -1;
        }
        char[] char1 = str1.toCharArray();
        char[] char2 = str2.toCharArray();
        int i=0;
        int j=0;
        int[] nextArray = getNextArray(char2);
        while (j < char2.length && i <char1.length){
            //if判断的条件为匹配上了继续向后面匹配
            if (char1[i] ==char2[j]){
                i++;
                j++;
            //else if为i在第一个数组的-1位置，向后移动一位
            }else if (nextArray[j] ==-1){
                i++;
            }else {
             //从新的前缀中寻找有没有匹配上的前缀继续匹配
                j=nextArray[j];
            }
        }
        return j==str2.length() ? i-j : -1;
    }
    /**
       得到最长前缀，和最长后缀的数组
    */
    public static int[] getNextArray(char[] chars){
        //若数组中只有没有值返回-1
        if (chars.length ==0){
            return new int[]{-1};
        }
        //0和1位置是规定好的-1和0
        int[] next=new int[chars.length];
        next[0]=-1;
        next[1]=0;
        //i代表从第二个位置开始，cn代表着跳到的位置
        int i=2;
        int cn=0;
        while (i<next.length){
            if (next[i-1] ==chars[cn]){
                //前缀的后面那个值，和后缀的后面的那个值相同，最长前缀和最长后缀分别相加
                next[i++]=++cn;
            }else if (cn >0){
                //从cn的位置继续寻找
                 i=next[cn];
            }else {
                //找不到最长前缀和最长后缀返回0
                next[i++]=0;
            }
        }
        return next;
    }
}
