package DP;
/**
*@author zhenglize
  打印所有的字符串子串
*/
public class PrintAllSubsquences {
    /**
      @param seqs 当前的字符串数组
     @param i 当前推进到了哪个位置
     @param res 输出的结果
    */
    public static void printStr(char[] seqs,int i,String res){
        //当来到最后一个字符串，结束递归过程
        if (i == seqs.length){
            System.out.println(res);
            return;
        }
        //共有两个策略，一个是，选择打印当前的字符串，另一个是字节略过
        printStr(seqs,i+1,res);
        printStr(seqs,i+1,res+String.valueOf(seqs[i]));
    }

    public static void main(String[] args) {
        String str="abc";
        printStr(str.toCharArray(),0,"");
    }
}
