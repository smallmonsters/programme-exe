import {mergeTwoLists} from "../../src/leetcode/mergeTwoLists";
import {arrToListNode, listNodeToArray} from "../../src/utils/arrToListNode";

describe('合并两个有序链表', () => {
  test('用例一', () => {
    expect(listNodeToArray(mergeTwoLists(arrToListNode([1,2,3]),arrToListNode([2,4,6])))).toStrictEqual([1,2,2,3,4,6])
  })
  test('用例二', () => {
    expect(listNodeToArray(mergeTwoLists(arrToListNode([1,2,3]),arrToListNode([2,4,6])))).toStrictEqual([1,2,2,3,4,5])
  })
  test('用例三', () => {
    expect(listNodeToArray(mergeTwoLists(arrToListNode([1,2,3]),arrToListNode([2,4,6])))).toStrictEqual([1,2,2,3,4,5])
  })
  test('用例四', () => {
    expect(listNodeToArray(mergeTwoLists(arrToListNode([1,2,3]),arrToListNode([2,4,6])))).toStrictEqual([1,2,2,3,4,5])
  })
  test('用例五', () => {
    expect(listNodeToArray(mergeTwoLists(arrToListNode([1,2,3]),arrToListNode([2,4,6])))).toStrictEqual([1,2,2,3,4,5])
  })
})
