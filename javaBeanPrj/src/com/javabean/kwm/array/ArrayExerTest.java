package com.javabean.kwm.array;

/**
 * 数组的复制，反转、查找
 * 数组中查找： 线性查找，二分法查找（所查找的数组必须有序）
 */
public class ArrayExerTest {

    public static void main(String[] args) {
        int arr[] = new int[]{-33,-21,-10,0,20,30,34,50};

        //线性查找
        int dest = 20;//目标值
        boolean isFlag = true;
        for (int i = 0;i < arr.length -1;i++){

            if (dest == arr[i]){
                System.out.println("找到了指定的元素，位置为：" + i);
                isFlag = false;
                break;
            }
        }

        if (isFlag){
            System.out.println("很遗憾，没有找到对应的元素！");
        }

        System.out.println("********************************");
        //二分法查找：所要查找的数组必须有序
        int dest1 = 30;//目标值
        //设置初始位置和末尾下标
        int start = 0;//首位置下标
        int end = arr.length -1 ;//末位置下标
        boolean isFlag1 = true;

        while (start <= end){

            //二分法下标
            int middle = (start + end)/2;
            if (dest1 == arr[middle]) {
                System.out.println("找到了指定的元素，位置为：" + middle);
                isFlag1 = false;
                break;
            }else if (dest1 > arr[middle]){
                start = middle + 1;
            }else {
                //dest1 < arr[middle])
                end = middle - 1;
            }
        }
        if (isFlag1){
            System.out.println("很遗憾，没有找到对应的元素！");
        }
    }
}
