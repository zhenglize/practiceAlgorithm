package DP;
/**
*@author zhenglize
 打印从左上位置到右下位置的最短路径和
*/
public class printMinWalk {
    /**
     @param matrix 待打印的矩阵
     @param i 矩阵的行
     @param j 矩阵的列
    */
    public static int walk(int[][] matrix,int i,int j){
        //若当前位置为矩阵的最后一个位置，打印
        if (i == matrix.length-1 && j==matrix[0].length-1){
            return matrix[i][j];
        }
        //假设到了最后一行
        if (i == matrix.length -1){
            return matrix[i][j] +walk(matrix,i,j+1);
        }
        //假设到了最后一列
        if (j ==matrix[0].length-1){
            return matrix[i][j]+walk(matrix,i+1,j);
        }
        int right=walk(matrix,i,j+1);
        int down=walk(matrix,i+1,j);
        return matrix[i][j]+Math.min(right,down);
    }
}
