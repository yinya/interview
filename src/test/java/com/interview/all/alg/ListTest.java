package com.interview.all.alg;

import lombok.Data;
import org.junit.jupiter.api.Test;

/**
 * @author yinya
 * @date 2021/4/7
 */
public class ListTest {

    @Data
    public static class Node {
        private String obj;
        private Node next;

        public Node() {
        }
        public Node(String obj, Node next) {
            this.obj = obj;
            this.next = next;
        }
    }

    /**
     * 翻转链表题
     * <p>
     * 1->2->3->4->null
     * 转化完
     * 4->3->2->1->null
     */
    @Test
    public void test01() {
        Node head = construct();
        printList(head);
        Node list = reverseList(head);
        printList(list);
    }

    /**
     * 两两翻转
     *
     * 1->2->3->4->null
     * 转化完
     * 2->1->4->3->null
     *
     * 1->2->3->4->5->null
     * 转化完
     * 2->1->4->3->5->null
     */
    @Test
    public void test02(){
        Node head = construct();
        printList(head);
        Node newHead = betweenReverseList(head);
        printList(newHead);
    }
    @Test
    public void test03(){
        Node head = smallConstruct();
        printList(head);
        Node newHead = betweenReverseList(head);
        printList(newHead);
    }

    /**
     * 判断链表是否有环
     *
     * 1.遍历并将值放到set集合。进行判断
     * 2。快慢指针
     */
    @Test
    public void test04(){

        Node head = constructCircleList();
        boolean circle = hasCircle(head);
        System.out.println(circle);

        head = construct();
        circle = hasCircle(head);
        System.out.println(circle);
    }

    private Node constructCircleList() {
        Node num4 = new Node("4", null);
        Node num3 = new Node("3", num4);
        Node num2 = new Node("2", num3);
        Node num1 = new Node("1", num2);
        Node num0 = new Node("0", num1);
        num4.next = num2;
        return num0;
    }

    private boolean hasCircle(Node head) {
        Node fast = head, slow = head;
        while (fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }

    /**
     * 断链时 优先读，再断
     * @param head
     * @return
     */
    private Node betweenReverseList(Node head) {
        Node newHead = null, a = null, b = null,pre = null;
        while (head != null && head.next != null){
            a = head;
            b = head.next;
            head = head.next.next;
            a.next = head;
            b.next = a;
            // 起始时。pre为nil
            if(pre != null){
                pre.next = b;
            }
            pre = a;

            // 起始时。newHead取第二个对象
            if(newHead == null){
                newHead = b;
            }

        }
        // 有可能head长度小于2
        return newHead != null? newHead: head;
    }

    private Node construct(){
        Node num4 = new Node("4", null);
        Node num3 = new Node("3", num4);
        Node num2 = new Node("2", num3);
        Node num1 = new Node("1", num2);
        Node num0 = new Node("0", num1);
        return num0;
    }
    private Node smallConstruct(){
        Node num0 = new Node("0", null);
        return num0;
    }

    private void printList(Node head){
        while (head != null){
            System.out.print(head.obj);
            System.out.print("===>");
            head = head.next;
        }
        System.out.println();
    }
    private Node reverseList(Node head) {
        Node newHead = null, pre = null;
        while (head != null){
            pre = head;
            head = head.next;
            pre.next = newHead;
            newHead = pre;
        }
        return newHead;
    }
}
