/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * https://leetcode.cn/problems/merge-two-sorted-lists/
 *  合并两个有序链表
 * @param {{val: *, next: null}|{val: *, next: *}} list1
 * @param {{val: *, next: null}|{val: *, next: *}} list2
 * @return {{val: *, next: ListNode}}
 */

function ListNode(val, next) {
  this.val = (val===undefined ? 0 : val)
  this.next = (next===undefined ? null : next)
}

export const mergeTwoLists = function (list1, list2) {
  const list = {val: null, next: null}
  let last = list
  while (list1 && list2) {
    debugger
    if (list1.val > list2.val) {
      const next = list2.next
      list2.next = null
      last.next = list2
      last = last.next
      list2 = next
    } else {
      const next = list1.next
      list1.next = null
      last.next = list1
      last = last.next
      list1 = next
    }
  }
  last.next = list1 || list2
  return list.next
};


//better
var mergeTwoListsBetter=function(list1,list2){
  let prevHead = new ListNode(0,null);
  let prev = prevHead;
  while(list1 !== null && list2 !== null) {
    if(list1.val < list2.val) {
      prev.next = list1;
      list1 = list1.next;
    } else {
      prev.next = list2;
      list2 = list2.next
    }
    prev = prev.next
  }
  prev.next = list1 === null ? list2 : list1;
  return prevHead.next;
}

// 递归
var mergeTwoListsRecursion = function(list1, list2) {
    if(!list1){
        return list2;
    }
    if(!list2){
        return list1;
    }
    if(list1.val<list2.val){
        list1.next=mergeTwoLists(list1.next,list2);
        return list1;
    }else{
        list2.next=mergeTwoLists(list1,list2.next);
        return list2;
    }
};
