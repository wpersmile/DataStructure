package org.wpersmile;
import java.util.ArrayList;

/**
 * 无头节点单链表实现
 * @author wperSmile
 * @param <E>
 *     指定传入数据类型
 */
public class SingleLinkedList<E> {
    private Node<E> first;
    private Node<E> next;

    //构造空链表
    public SingleLinkedList(){
        this.first=null;
        this.next=null;
    }

    /**
     * 定义一个链表结点
     * @param <E>
     */
    private static class Node<E>{
        E elem;
        Node<E> next;
        Node(E elem,Node<E> next){
            this.elem=elem;
            this.next=next;
        }
    }

    /**
     * 判断链表是否为空
     * @return
     * ture：链表为空
     * flase:链表有值
     */
    public Boolean isEmpty(){
        if(this.first==null){
            return true;
        }
        return false;
    }

    /**
     * 清空链表
     */
    public void clean(){
        this.first=null;
    }


    /**
     * 添加新元素
     *如果队列为空，则新结点为首结点，否则把新结点指向队列最后一个结点
     * @param e
     */
    public void add(E e){
        Node<E> newNode=new Node<>(e,next);
        if (isEmpty()){
            this.first=newNode;
        }
        else {
            Node<E> p=this.first;
         while (p.next!=null){
             p=p.next;
         }
         p.next=newNode;
        }
    }

    /**
     *在指定位置插入元素
     * @param index  index为插入元素索引位置
     * @param e 插入元素e，插入点为索引位置之后
     */
    public void insertIndex(int index,E e){
        Node<E> newNode=new Node<E>(e,next);
        Node<E> p=this.first;
        int count=0;
        while (p.next!=null){
            count++;
            if(count==index){
                newNode.next=p.next;
                p.next=newNode;
                break;
            }
            p=p.next;
        }
    }

    /**
     *在指定位置删除元素
     * 从 0 开始
     * @param index  index为删除元素索引位置
     */
    public void deleteIndex(int index){
        Node<E> p=this.first;
        int count=0;
        if (p!=null){
            if(index==0){
                this.first=p.next;
            }
            while (p.next!=null){
                count++;
                if(count==index){
                    p.next=p.next.next;
                    break;
                }
                p=p.next;
            }
        }
    }

    /**
     * @return 获取链表长度
     */
    public int length(){
        int length=0;
        Node<E> p=this.first;
        if (p==null){
            return 0;
        }
        else {
            while (p.next!=null){
                length++;
                p=p.next;
            }
            //while循环少了链表最后一个元素的，因此还要 + 1
            length++;
        }
        return length;
    }

    /**
     * 链表转数组
     *@return 返回转换好的ArrayList
     */

    public ArrayList toArray(){
        Node<E> p=this.first;
        ArrayList<E> arrayList=new ArrayList<E>();
        if (p!=null){
            while (p.next!=null){
                arrayList.add(p.elem);
                p=p.next;
            }
            arrayList.add(p.elem);
        }
        return arrayList;
    }

    /**
     * 单链表反转（数组实现）
     * 思路：将链表元素输入到数组中，然后清空原来队列，最后将数组倒序输出到链表中。
     */
    public void reLinedList(){
        Node<E> p=this.first;
        if (p!=null){
            ArrayList<E> arrayList=new ArrayList<E>();
            while (p.next!=null){
                arrayList.add(p.elem);
                p=p.next;
            }
            arrayList.add(p.elem);
            clean();
            for (int i=arrayList.size()-1;i>=0;i--){
                add(arrayList.get(i));
            }
        }
    }


    /**
     * 先找到首节点，然后交换新节点和首节点在链表中的位置，最后交换elem的值。
     * 头插：在第一个元素之前插入新的元素
     * @param e
     */
    public void addFirst(E e){
        Node<E> firstNode=this.first;
        Node<E> newNode=new Node<E>(e,this.next);
        if (firstNode==null){
            this.first=newNode;
        }
        else {
            //将newNode节点的next指向firstNode节点的next; 即newNode节点的next指向第二个节点。 ： 0 -> 2
            newNode.next=first.next;
            //将firstNode节点的next指向newNde节点;即firstNode节点的next指向newNode节点。 ：1 -> 0
            firstNode.next=newNode;
            //上面交换了firstNode和newNode的顺序，因此只需要交换各自节点的elem，就能实现头插。
            //定义temp用于交换newNode和firstNode的elem元素。
            E temp;
            temp=firstNode.elem;
            firstNode.elem=newNode.elem;
            newNode.elem=temp;
        }
    }

    /**
     *
     * @return 返回链表所有元素集合
     */
    @Override
    public String toString(){
        Node<E> p=this.first;
        if (p==null){
            return "[]";
        }
        String str="[";
        while (p.next!=null){
            str+=p.elem;
            str+="，";
            p=p.next;
        }
        str+=p.elem+"]";
        return str;
    }

    /**
     * 用于查询元素e是否在队列中存在
     * @param e
     * @return 存在：true 不存在：false
     */
    public Boolean isExists(E e){
        Node<E> p=this.first;
        if(p==null){
            return false;
        }
        else {
            while(p.next!=null){
                if (e.equals(p.elem)){
                    return true;
                }
                p=p.next;
            }
            if (e.equals(p.elem)){
                return true;
            }
        }
        return false;
    }


    /**
     * 统计elem元素在队列中出现的个数
     * @param e
     * @return 返回次数
     */
    public int countElem(E e){
        int count=0;
        Node<E> p=this.first;
        if(p==null){
            return count;
        }
        else {
            while(p.next!=null){
                if (e.equals(p.elem)){
                    count++;
                }
                p=p.next;
            }
            if (e.equals(p.elem)){
                count++;
            }
        }
        return count;
    }

    /**
     * 链表拼接，将其他链表拼接到当前链表最后一个元素之后
     * @param A 链表A
     * @param B 链表B
     * @return  返回合并后的链表
     */
    public SingleLinkedList<E> splice(SingleLinkedList<E> A, SingleLinkedList<E> B){
        Node<E> p1=A.first;
        if (p1!=null){
            while (p1.next!=null){
                p1=p1.next;
            }
            p1.next=B.first;
        }
        else {
            if (B.first!=null){
                A.first=B.first;
            }
        }
        return A;
    }
}