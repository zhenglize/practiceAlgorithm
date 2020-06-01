package otherproblem;
/**
*@author zhenglize
转圈打印矩阵
【题目】 给定一个整型矩阵matrix，请按照转圈的方式打印它。
例如： 1   2   3   4
      5   6   7   8
      9   10  11  12
      13  14  15  16
打印结果为：1，2，3，4，8，12，16，15，14，13，9，5，6，7，11， 10
【要求】 额外空间复杂度为O(1)。
*/
public class PrintMatrixSpiralOrder {
      /**
      * @param matrix 待打印的矩阵
      */
    public static void spiralOrderMatrix(int[][] matrix){
          //设置两个点位置，左上角和右下角
          int leftRaw=0;
          int leftColumn=0;
          int rightRaw=matrix.length-1;
          int rightColumn=matrix[0].length-1;
          while (leftRaw <=rightRaw && leftColumn <=rightColumn){
                printEdge(matrix,leftRaw++,leftColumn++,rightRaw--,rightColumn--);
          }
    }
      /**
      *@author zhenglize
       @param matrix 待打印的矩阵
       @param leftRaw 左上角的横坐标
       @param leftColumn 左上角的列
       @param rightRaw 右下角的横坐标
       @param rightColumn 右下角的纵坐标
      */
      private static void printEdge(int[][] matrix, int leftRaw, int leftColumn, int rightRaw, int rightColumn) {
            //他们在一行，只打印列即可
            if (leftRaw == rightRaw){
                for (int i = leftColumn; i <=rightColumn ; i++) {
                      System.out.print(matrix[leftRaw][i]+" ");
                }
                //他们在一列只打印一行即可
          } else if (leftColumn == rightColumn){
                  for (int i = leftRaw; i <=rightRaw ; i++) {
                        System.out.print(matrix[i][leftColumn]+" ");
                  }
            } else {
                //他们即不再一行，也不在一列
                  int curR=leftRaw;
                  int curC=leftColumn;
                  while (curC!=rightColumn){
                        System.out.print(matrix[leftRaw][curC++]+" ");
                  }
                  while (curR!=rightRaw){
                        System.out.print(matrix[curR++][rightColumn]+" ");
                  }
                  while (curC!=leftColumn){
                        System.out.print(matrix[rightRaw][curC--]+" ");
                  }
                  while (curR!=leftRaw){
                        System.out.print(matrix[curR--][leftColumn]+" ");
                  }
            }
      }

      public static void main(String[] args) {
            int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
            spiralOrderMatrix(matrix);
            //print 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
      }
}
