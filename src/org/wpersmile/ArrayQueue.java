package org.wpersmile;

import java.util.ArrayList;

/**
 * @param <E>
 *     指定传入数据类型
 * @author wperSmile
 */
public class ArrayQueue<E> {
    private Queue<E> queue;
    private static class Queue<E>{
        int front;//队首
        int rear; //队尾
        ArrayList<E> data;//用于存储队列的数据

    }
    //构造空队列
    public ArrayQueue(){
        queue=new Queue();
        queue.data=new ArrayList<E>();
    }

    public boolean isEmpty(){
        //如果队尾和队首相等，那么队列为空
        if(queue.rear==queue.front){
            return true;
        }
        return false;
    }
    public void insertQueue(E e){
        //每次插入新元素，队列长度+1，也就是队尾+1
        queue.data.add(e);
        queue.rear++;
    }
    public void deleteQueue(){
        if (!isEmpty()){
            queue.data.remove(queue.rear-1);
            queue.rear--;
        }
    }
    @Override
    public String toString(){
        String str="[";
        for (int i=0;i<queue.rear;i++){
            str+=queue.data.get(i);
            if (queue.rear-1!=i)
                str+=",";
        }
        return str+"]";
    }
}
