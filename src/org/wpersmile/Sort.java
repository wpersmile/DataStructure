package org.wpersmile;

public class Sort {

    /**
     * 冒泡排序-升序
     * 时间复杂度O(n)-O(n^2)
     * @param arr int类型数组
     * @return 排序好的数组
     */
    private static int[] bubbleSort1(int[] arr){
        //数据交换中间变量
        int temp;
        //用于判断数组元素是否进行了次序交换
        boolean  state;
        for (int i = 0; i < arr.length; i++) {
            state=false;
            for(int j=0;j<arr.length-1-i;j++) {
                //当数组前面的元素比后面的元素大时，交换他们之间的元素
                if (arr[j]>arr[j+1]) {
                    temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    //如果有进行次序交换，则赋值true
                    state=true;
                }
            }
            //如果该轮没有比较，表示已经排序完毕 返回该数组
            if (!state){
                return arr;
            }
        }
        return arr;
    }
}
