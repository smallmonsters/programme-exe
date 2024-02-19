package leetcode.simple;

//https://leetcode.cn/problems/kth-node-from-end-of-list-lcci/submissions/  返回倒数第 k 个节点
public class KthToLast {

  //  NOTE:自己写的，用int来记录应该有一个问题，ListNode的长度可能超过int的范围
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

  //NOTE: ChatGPT 改的
  public int kthToLastByChatGPT(ListNode head, int k) {
    int len = 0;
    ListNode node = head;
    while (node != null) { // 修正条件
      node = node.next;
      ++len;
    }
    node = head;
    for (int i = 0; i < len - k; i++) { // 修改循环范围
      node = node.next;
    }
    return node.val;
  }

  // note:其他方法，快慢指针，List是快指针，head是慢指针
  public int kthToLast1(ListNode head, int k) {
    ListNode list = head;
    for (int i = 1; i < k; i++) {
      list = list.next;
    }
    while (list.next != null) {
      head = head.next;
      list = list.next;
    }
    return head.val;
  }


  public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
    }
  }
}
