import {longestCommonPrefix} from "../../src/leetcode/longestCommonPrefix";

describe(' 最长公共前缀', () => {
  test('用例一', () => {
    expect(longestCommonPrefix(["flower","flow","flight"])).toStrictEqual("fl")
  })
  test('用例二', () => {
    expect(longestCommonPrefix(["dog","racecar","car"])).toStrictEqual("")
  })
  test('用例二', () => {
    expect(longestCommonPrefix(["dog","","dog"])).toStrictEqual("")
  })
  test('用例二', () => {
    expect(longestCommonPrefix(["dog",])).toStrictEqual("dog")
  })
})
