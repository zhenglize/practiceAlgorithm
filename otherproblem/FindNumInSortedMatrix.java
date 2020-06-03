package otherproblem;
/**
*@author zhenglize
在行列都排好序的矩阵中找数
【题目】 给定一个有N*M的整型矩阵matrix和一个整数K，
matrix的每一行和每一列都是排好序的。实现一个函数，判断K是否在matrix中。
例如： 0 1 2 5
      2 3 4 7
      4 4 4 8
      5 7 7 9
如果K为7，返回true；如果K为6，返回false。
【要求】 时间复杂度为O(N+M)，额外空间复杂度为O(1)。
 解题思路:
  定义右上角的那个点，若找到的数小于K，则右上角的点向下移动，若大于则右上角的向左移动，找到就返回true

*/
public class FindNumInSortedMatrix {
    /**
      @param matrix 有序的矩阵
      @param K 待寻找的数字K
    */
     public static boolean findNumInSortedMatrix(int[][] matrix,int K){
         int raw=0;
         int col=matrix[0].length-1;
         while (raw < matrix.length-1 && col >-1){
             if (matrix[raw][col]==K){
                 return true;
             }else if (matrix[raw][col] >K){
                 col--;
             }else {
                 raw++;
             }
         }
         return false;
     }

    public static void main(String[] args) {
        int[][] m={{0,1,2,5},{2,3,4,7},{4,4,4,8},{5,7,7,9}};
        System.out.println(findNumInSortedMatrix(m, 7));
        System.out.println(findNumInSortedMatrix(m, 6));
        /**
         true
         false
        */
    }
}
