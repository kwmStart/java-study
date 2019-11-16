package com.javabean.kwm.array;

/**
 * 回形数
 *
 *  1  2  3  4  5  6  7
 * 24 25 26 27 28 29  8
 * 23 40 41 42 43 30  9
 * 22 39 48 49 44 31 10
 * 21 38 47 46 45 32 11
 * 20 37 36 35 34 33 12
 * 19 18 17 16 15 14 13
 */
public class RectangleTest {

    public static void main(String[] args) {
        int n = 8;
        int[][] arr = new int[n][n];

        int count = 0; //要显示的数据
        int maxX = n - 1; //X轴的最大下标
        int maxY = n - 1; //y轴的最大下标
        int minX = 0 ; //x轴的最小下标
        int minY = 0 ; //y轴的最小下标

        while (minX <= maxX) {
            //第一行
            for (int x = minX;x <= maxX;x++){
                arr[minY][x] = ++count;
            }
            minY++;
            //最后一列
            for (int y = minY;y <= maxY; y++){
                arr[y][maxX] = ++count;
            }
            maxX--;
            //
            for (int x = maxX;x>=minX;x--){
                arr[maxY][x] = ++count;
            }
            maxY--;
            for (int y = maxY;y >= minY;y--){
                arr[y][minX] = ++count;
            }
            minX++;
        }

        //3、遍历二维数组
        for (int i = 0;i < arr.length;i++){
            //遍历内层数组
            for (int j = 0;j < arr[i].length;j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
