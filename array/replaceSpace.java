package array;
/**
*@author zhenglize
请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
示例 1：
输入：s = "We are happy."
输出："We%20are%20happy."

*/
public class replaceSpace {
    public static String replaceSpace(String s) {
        String res="";
        for (int i = 0; i < s.length(); i++) {
            if (" ".equals(s.substring(i,i+1))){
                res+="%20";
            }else {
                res+=s.substring(i,i+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s="We are happy.";
        System.out.println(replaceSpace(s));
    }
}
