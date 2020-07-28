package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
*@author zhenglize
 逆波兰计算器
*/
class Opera{
    private static int ADD=1;
    private static int SUB=1;
    private static int MUL=2;
    private static int DIV=2;
    public static int getValue(String val){
        int res=0;
        switch (val){
            case "+":
                res=ADD;
                break;
            case "-":
                res=SUB;
                break;
            case "*":
                res=MUL;
                break;
            case "/":
                res=DIV;
                break;
            default:
                System.out.println("您输入的符号有误");
                break;
        }
        return res;
    }
}
public class PolandNotation {
    public static void main(String[] args) {
        String res="1+((2+3)*4)-5";
        List<String> list = suffixString(res);
        System.out.println("中缀表达式为:"+list);
        List<String> suffixExpression = parseSuffixStringList(list);
        System.out.println("转换的后缀表达式为:"+suffixExpression);

     /*   //计算后缀表达式的结果
        String suffixExpression="3 4 + 5 * 6 -";
        List<String> listString = getListString(suffixExpression);
        int res = calculate(listString);
        System.out.println("计算的结果是:"+res);*/
    }
    //将中缀表达式转换为后缀表达式
    public static List<String> parseSuffixStringList(List<String> list){
        //符号栈s1
        Stack<String> s1=new Stack<>();
        //由于没有出栈操作，所以使用集合来替代栈
        List<String> s2=new ArrayList<>();
        for(String item : list){
            //如果匹配到的是数字直接入s2
            if (item.matches("\\d+")){
                s2.add(item);
            }
            else if (item.equals("(")){
                //如果是左括号直接入s1
                s1.push(item);
            }else if (item.equals(")")){
                //弹出s1中的数字，直到和小括号（匹配尾值
                while (!s1.peek().equals("(")){
                    s2.add(s1.pop());
                }
                //将(消除
                s1.pop();
            }else {
                //如果是符号，则比较栈顶的优先级
                while (s1.size()!=0
                        && Opera.getValue(s1.peek()) >= Opera.getValue(item)){
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        //若s1中还有符号，则直接弹出到s2中
        while (!s1.isEmpty()){
            s2.add(s1.pop());
        }
        return s2;
    }
    //将字符串转换放入list集合中
    public static List<String> suffixString(String str){
        List<String> list=new ArrayList<>();
        int index=0; //记录字符串移动的指针
        String res="";
        char c;
        do {
            //判断是否为操作符
            if ((c=str.charAt(index)) <48 || (c=str.charAt(index)) >57){
                list.add(c+"");
                index++;
            }else {
                res="";
                //判断数字的位数
                while ( (index < str.length())  &&
                        (c=str.charAt(index)) >=48 &&
                        (c=str.charAt(index)) <=57){
                    res+=c;
                    index++;
                }
                list.add(res);
            }
        }while (index < str.length());
        return list;
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
