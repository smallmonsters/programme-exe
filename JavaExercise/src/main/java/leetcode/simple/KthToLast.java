package leetcode.simple;

//https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/submissions/
public class KthToLast {
  public int kthToLast(ListNode head, int k) {

    int len = 1;
    ListNode node = head;
    while (node.next != null) {
      node = node.next;
      ++len;
    }
    node = head;
    for (int i = 0; i < len; i++) {
      if (i == len - k) break;
      node = node.next;
    }
    return node.val;
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {val = x;}
  }
}
