package com.github.mrkinghh.offer;

public class ListNode {
  int data = -1;
  ListNode next = null;

  public ListNode() {
  }

  public ListNode(int data) {
    this.data = data;
  }

  //头插法建表就是倒序的
  public static ListNode createListHead(int[] arr) {
    //头插法创建链表
    ListNode head = new ListNode();
    for (int elem : arr) {
      ListNode node = new ListNode(elem);
      node.next = head.next;
      head.next = node;
    }
    //返回链表头结点
    return head;
  }

  //尾插法建表是顺序的
  public static ListNode createListTail(int[] arr) {
    //尾插法创建链表
    ListNode head = new ListNode();
    ListNode p = head;
    for (int elem : arr) {
      ListNode node = new ListNode(elem);
      p.next = node;
      p = node;
    }

    return head;
  }

  //传入的是不带头结点的链表
  public static void printList(ListNode list) {
    System.out.println("打印链表：");
    ListNode head = list;
    while (head != null) {
      System.out.print(head.data + " ");
      head = head.next;
    }
    System.out.println();
  }
}
