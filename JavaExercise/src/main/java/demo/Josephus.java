package demo;

import hepler.ListNode;


public class Josephus {
  public static void main(String[] args) {

    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    ListNode node5 = new ListNode(5);
    ListNode node6 = new ListNode(6);
    ListNode node7 = new ListNode(7);
    node7.next = node1;
    node6.next = node7;
    node5.next = node6;
    node4.next = node5;
    node3.next = node4;
    node2.next = node3;
    node1.next = node2;
    System.out.println(getLast(node1));
    System.out.println(getLastByAi(node1, 3));
  }

  public static int getLast(ListNode head) {
    ListNode cur = head;
    while (head.val != head.next.val) {
      int m = 3;
      for (int i = 0; i < m - 1; m--) {
        cur = cur.next;
      }
      head.next = cur.next;
      head = head.next;
      cur = head;
    }
    return head.val;
  }

  public static int getLastByAi(ListNode head, int m) {
    ListNode cur = head;
    while (cur.next != cur) {
      for (int i = 1; i < m - 1; i++) {
        cur = cur.next;
      }
      cur.next = cur.next.next;
      cur = cur.next;
    }

    // 返回最后剩下的节点的编号
    return cur.val;
  }

}
