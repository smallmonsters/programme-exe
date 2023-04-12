package leetcode.simple;


import java.util.Arrays;
import java.util.Stack;


//https://leetcode.cn/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/ 从尾到头打印链表
public class ReversePrint {
  public static void main(String[] args) {
    
    ReversePrint.ListNode node1 = new ReversePrint.ListNode(1);
    ReversePrint.ListNode node2 = new ReversePrint.ListNode(2);
    ReversePrint.ListNode node3 = new ReversePrint.ListNode(3);
    ReversePrint.ListNode node4 = new ReversePrint.ListNode(4);
    node4.next = node1;
    node3.next = node4;
    node2.next = node3;
    node1.next = node2;
    ReversePrint.reversePrint(node1);
  }

  //note: 也可以使用ReverseList，反转链表再
  public static int[] reversePrint(ListNode head) {

    if (head == null) return new int[]{};
    ListNode cur = head;
    Stack<Integer> stack = new Stack<Integer>();
    while (cur != null) {
      stack.push(cur.val);
      cur = cur.next;
    }
    int size = stack.size();
    int[] print = new int[size];
    for (int i = 0; i < size; i++) {
      print[i] = stack.pop();
    }
    System.out.println(Arrays.toString(print));
    return print;
  }

  public static class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {val = x;}
  }
}
