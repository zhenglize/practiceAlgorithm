package DP;
/**
*@author zhenglize
  汉诺塔问题
 打印汉诺塔问题的实现步骤
 共有左中右三个杆子，将N层塔移动到最右，大致可以分为三个步骤
 1.从最左到中间
 2.从最左到最右
 3.从中间到最右
*/
public class Hanoi {
    public static void process(int N, String from ,String to , String help){
        if (N ==1){
            System.out.println("Move 1 From " +from +" To " +to);
        }else {
            process(N-1,from,help,to);
            System.out.println("Move "+N+" From "+from+" To "+to);
            process(N-1,help,to,from);
        }
    }

    public static void main(String[] args) {
        int N=3;
        process(N,"左","右","中");
        /**
         Move 1 From 左 To 右
         Move 2 From 左 To 中
         Move 1 From 右 To 中
         Move 3 From 左 To 右
         Move 1 From 中 To 左
         Move 2 From 中 To 右
         Move 1 From 左 To 右
        */
    }
}
