package org.wpersmile;

public class Search {

    /**
     * 二分查找算法递归形式
     * @param arr 排序好的整形数组
     * @param left 最左边的元素 初始值 ：0
     * @param right 最右边的元素 初始值 ：arr.length-1
     * @param searchNum 需要查找的元素
     * @return 如果找到返回该元素的下标位置
     *               反之返回-1
     */
    public int binarySearch(int arr[],int left,int right,int searchNum){

        if(left>right){
            return -1;
        }
        else {
            int mid=(left+right)/2;
            if (searchNum>arr[mid]){
                return binarySearch(arr,mid+1,right,searchNum);
            }
            else if (searchNum<arr[mid]){
                return binarySearch(arr, left, mid-1, searchNum);
            }
            else {
                return mid;
            }
        }
    }
}
