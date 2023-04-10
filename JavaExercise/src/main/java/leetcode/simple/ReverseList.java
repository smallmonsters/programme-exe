package leetcode.simple;

//https://leetcode.cn/problems/UHnkqh/  反转链表
public class ReverseList {
  ReverseList() {
    ListNode node1 = new ListNode(1);
    ListNode node2 = new ListNode(2);
    ListNode node3 = new ListNode(3);
    ListNode node4 = new ListNode(4);
    node4.next = null;
    node3.next = node4;
    node2.next = node3;
    node1.next = node2;
    //    ListNode node = reverseListByFor(node1);
    //
    //    while (node != null) {
    //      System.out.print(node.val);
    //      node = node.next;
    //    }

    ListNode node = reverseList(node1);

    while (node != null) {
      System.out.print(node.val);
      node = node.next;
    }
  }

  // note: 别人写的递归
  private static ListNode reverseByOther(ListNode pre, ListNode cur) {
    if (cur == null) return pre;
    ListNode next = cur.next;
    cur.next = pre;
    return reverseByOther(cur, next);
  }

  //  note:看了解析写的
  public ListNode reverseListByFor(ListNode head) {
    ListNode cur = head;
    ListNode pre = null;
    ListNode next = null;
    while (cur != null) {
      next = cur.next;
      cur.next = pre;
      pre = cur;
      cur = next;
    }
    return pre;
  }

  public ListNode reverseList(ListNode head) {
    return reverse(null, head);
  }

  //  note:知道递归后，自己琢磨的
  public ListNode reverse(ListNode reverseNode, ListNode node) {
    if (node == null) return reverseNode;
    ListNode next = node.next;
    ListNode pre = reverseNode;
    reverseNode = node;
    reverseNode.next = pre;
    pre = reverseNode;
    return reverse(pre, next);
  }

  public class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {this.val = val;}

    ListNode(int val, ListNode next) {
      this.val = val;
      this.next = next;
    }
  }
}
