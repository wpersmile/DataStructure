package org.wpersmile;

public class Sort {

    /**
     * 冒泡排序-升序
     * 时间复杂度O(n)-O(n^2)
     * @param arr 待排序的数组
     * @return 排序好的数组
     */
    public static int[] bubbleSort(int[] arr){
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


    /**
     * 选择排序-升序
     * 时间复杂度O(n^2)
     * @param arr 待排序的数组
     * @return 排序好的数组
     */
    public static int[] selectionSort(int[] arr){
        //记录排序一轮排序中的最小值
        int min;
        //记录最小值在数组中的位置
        int location=-1;
        //若初始位置的值不是最小值，则更改为false
        boolean state;
        for (int i=0;i<arr.length;i++){
            min=arr[i];
            state=true;
            for (int j=i+1;j<arr.length;j++){
                //若存在比min还小的元素，则将最小元素置为min,并记录位置，更该state属性
                if (min>arr[j]){
                    min=arr[j];
                    location=j;
                    state=false;
                }
            }
            //如果state被改变过，则进行元素交换
            if (!state){
                int temp;
                temp=arr[i];
                arr[i]=arr[location];
                arr[location]=temp;
            }
        }
        return arr;
    }

    /**
     * 直接插入排序-升序 时间复杂度
     * 时间复杂度O(n^2)
     * @param arr 待排序的数组
     * @return 排序后的数组
     */
    public static int[] insertSort(int[] arr){
        //默认第一个元素是有序的
        for (int i=1;i<arr.length;i++){
            int temp;
            for (int j=0;j<i;j++){
                //如果当前元素比与他比较的元素小，则交换他们的次序。
                if (arr[i]<arr[j]){
                    temp=arr[j];
                    arr[j]=arr[i];
                    arr[i]=temp;
                }
            }
        }
        return arr;
    }
}
