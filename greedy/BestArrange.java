package greedy;

import java.util.Arrays;
import java.util.Comparator;

/**
*@author zhenglize
一些项目要占用一个会议室宣讲，会议室不能同时容纳两个项目的宣讲。 给你每一个项目开始的时间和结束的时间
(给你一个数组，里面 是一个个具体的项目)，你来安排宣讲的日程，要求会议室进行 的宣讲的场次最多。
 返回这个最多的宣讲场次。
*/
public class BestArrange {
    //会议的开始与结束时间
    public static class Program{
        int start;
        int end;
        public Program(int start,int end){
            this.start=start;
            this.end=end;
        }
    }
    //贪心策略为按照会议的结束时间进行比较
    public static class ProgramComparator implements Comparator<Program>{

        @Override
        public int compare(Program o1, Program o2) {
            return o1.end-o2.end;
        }
    }
    /**
      @param programs 给定的需要安排的会议数组
     @param start 会议的开始时间
    */
    public static int maxProgram(Program[] programs , int start){
        Arrays.sort(programs,new ProgramComparator());
        int res=0;
        for (int i = 0; i < programs.length; i++) {
            if (start <=programs[i].start ){
                res++;
                start=programs[i].end;
            }
        }
        return res;
    }
}
