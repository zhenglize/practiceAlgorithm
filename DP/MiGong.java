package DP;

public class MiGong {
    public static void main(String[] args) {
        //先创建一个二维数组模拟迷宫
        int[][] map=new int[8][7];
        int row=map.length;
        int col=map[0].length;
        //绘制迷宫的墙
        for (int i = 0; i < row; i++) {
            map[i][0]=1;
            map[i][6]=1;
        }
        for (int i = 0; i < col; i++) {
            map[0][i]=1;
            map[7][i]=1;
        }
        //挡板
        map[3][1]=1;
        map[3][2]=1;
        setWay(map,1,1);
        //输出地图
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
    /**
       @param map 迷宫
     @param j，i 代表从哪个位置开始寻找
     @return 代表是否找到路
     当map[6][5]位置为2的时候代表找到了路，其中0代表没有走过的路，1代表墙，2代表走过的路
     3代表已经探测过的路
    */
    public static boolean setWay(int[][] map, int i ,int j){
        if (map[6][5] ==2){
            return true;
        }else {
            if (map[i][j] ==0){
                //假设当前的位置可以走
                map[i][j]=2;
                //寻路的策略为下 -》右 -》上-》左
                if (setWay(map,i+1,j)){
                    return true;
                }else if (setWay(map,i,j+1)){
                    return true;
                }else if (setWay(map,i-1,j)){
                    return true;
                }else if (setWay(map,i,j-1)){
                    return true;
                }else {
                    map[i][j]=3;
                    return false;
                }
            }else {
                //可能是1,2,3无法走了
                return false;
            }
        }
    }

}
