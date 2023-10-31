import {twoSum} from "../../src/leetcode/twoSum";

describe(' 两数之和', () => {
  test('用例一', () => {
    expect(twoSum([2, 7, 11, 15],9)).toStrictEqual([0, 1])
  })
})
