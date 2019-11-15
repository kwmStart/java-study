package com.javabean.kwm.array;

/**
 * 使用二维数组打印一个10行的杨辉三角
 * 提示：
 * 1、第一行有一个元素，第n行有n的元素
 * 2、每一行的第一个元素和最后一个元素都为1.
 * 3、从第三行开始，对于非第一个元素和最后一个元素的元素。即：
 * yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j]
 */
public class YangHuiTest {
    public static void main(String[] args) {

        //1.声明和初始化一个二维数组 使用动态初始化
        int[][] yanghui = new int[10][];
        //2、给数组元素赋值
        for (int i = 0;i < yanghui.length;i++){
            yanghui[i] = new int[i+1];

            //2.1、给首末元素赋值
            yanghui[i][0] = 1;
            yanghui[i][i] = 1;
            //2.2、给每行的首末元素赋值
            for (int j = 1;j < yanghui[i].length - 1; j++){
                yanghui[i][j] = yanghui[i-1][j-1] + yanghui[i-1][j];
            }
        }

        //3、遍历二维数组
        for (int i = 0;i < yanghui.length;i++){
            //遍历内层数组
            for (int j = 0;j < yanghui[i].length;j++){
                System.out.print(yanghui[i][j] + " ");
            }
            System.out.println();
        }
    }
}
