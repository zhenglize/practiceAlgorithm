package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
*@author zhenglize
 逆波兰计算器
*/
public class PolandNotation {
    public static void main(String[] args) {
        //计算后缀表达式的结果
        String suffixExpression="3 4 + 5 * 6 -";
        List<String> listString = getListString(suffixExpression);
        int res = calculate(listString);
        System.out.println("计算的结果是:"+res);
    }
    //将字符串放到集合中
    public static List<String> getListString(String suffix){
        String[] strings = suffix.split(" ");
        List<String> list=new ArrayList<>();
        for (String ele :strings) {
            list.add(ele);
        }
        return list;
    }
    //计算
    public static int calculate(List<String> list){
        Stack<String> stack=new Stack<>();
        for(String str: list){
            //匹配数字的正则表达式
            if (str.matches("\\d+")){
                stack.add(str);
            }else {
                int num1=Integer.parseInt(stack.pop());
                int num2=Integer.parseInt(stack.pop());
                int res=0;
                if (str.equals("+")){
                    res=num1+num2;
                }else if (str.equals("-")){
                    res=num2-num1;
                }else if (str.equals("*")){
                    res=num1*num2;
                }else if (str.equals("/")){
                    res=num2/num1;
                }else {
                    throw new RuntimeException("您输入的操作符有误");
                }
                stack.push(res+"");
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
