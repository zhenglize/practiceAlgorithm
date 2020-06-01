package otherproblem;
/**
*@author zhenglize
旋转正方形矩阵
【题目】 给定一个整型正方形矩阵matrix，请把该矩阵调整成顺时针旋转90度的样子。
【要求】 额外空间复杂度为O(1)。
     1  2  3  4
     5  6  7  8
     9  10 11 12
     13 14 15 16
*/
public class RotateMatrix {
    public static void rotate(int[][] matrix){
        int leftRaw=0;
        int leftColumn=0;
        int rightRaw=matrix.length-1;
        int rightColumn=matrix[0].length-1;
        while (leftRaw < rightRaw){
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
        int times=rightRaw-leftRaw;
        int help=0;
        for (int i = 0; i <times ; i++) {
            help=matrix[leftRaw][leftColumn+i];
            matrix[leftRaw][leftColumn+i]=matrix[rightRaw-i][leftColumn];
            matrix[rightRaw-i][leftColumn]=matrix[rightRaw][rightColumn-i];
            matrix[rightRaw][rightColumn-i]=matrix[leftRaw+i][rightColumn];
            matrix[leftRaw+i][rightColumn]=help;
        }
    }
    public static void printMatrix(int[][] matrix){
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
        }
    }
    public static void main(String[] args) {
        int[][] matrix={{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        rotate(matrix);
        printMatrix(matrix);
    }
}
