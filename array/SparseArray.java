package array;
/**
*@author zhenglize
  稀疏数组:将一个二维数组，压缩缩小进行存储类似于五子棋的棋盘
*/
public class SparseArray {
    public static void main(String[] args) {
        //初始化棋盘，为11行，11列的棋盘，第一行第二列有一个黑子记为1，第二行第三列有一个白子记为2
        int[][] cheeseArr=new int[11][11];
        int row=cheeseArr.length;
        int col=cheeseArr[0].length;
        cheeseArr[1][2]=1;
        cheeseArr[2][3]=2;
        //打印这个棋盘（二维数组）
        printCheese(cheeseArr);
        System.out.println();
        //求出共有几个不同的值，sum
        int sum=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (cheeseArr[i][j] != 0){
                    sum++;
                }
            }
        }
        System.out.println("sum="+sum);
        System.out.println();
        //将二维数组变成稀疏数组
        //行的值为不同数字的个数加一，列为固定的三列，第一个列记录行，第二个列记录不同数据的列，
        // 最后一个记录不同数据的值
        int[][] sparseArray=new int[sum+1][3];
        //给第一行赋值，第一行记录这个棋盘有几行几列，多少个不同值
        sparseArray[0][0]=row;
        sparseArray[0][1]=col;
        sparseArray[0][2]=sum;
        //给稀疏数组进行赋值
        int count=0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (cheeseArr[i][j] != 0){
                    count++;
                    sparseArray[count][0]=i;
                    sparseArray[count][1]=j;
                    sparseArray[count][2]=cheeseArr[i][j];
                }
            }
        }
        //打印稀疏数组
        printCheese(sparseArray);
        System.out.println();
        //还原稀疏数组转化为二维数组
        int[][] cheeseArr2=new int[sparseArray[0][0]][sparseArray[0][1]];
        //给待还原的二维数组赋值
        for (int i = 1; i < sparseArray.length; i++) {
             cheeseArr2[sparseArray[i][0]][sparseArray[i][1]]=sparseArray[i][2];
        }
        //打印还原的二维数组
        printCheese(cheeseArr2);
    }

    private static void printCheese(int[][] cheeseArr) {
        //打印这个棋盘（二维数组）
        for (int[] row :cheeseArr) {
            for (int item :row) {
                System.out.printf("%d\t",item);
            }
            System.out.println();
        }
    }
}
