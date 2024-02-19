import {coinChange} from "../../../src/leetcode/medium/coinChange";

describe('凑零钱', () => {
  test('用例一', () => {
    expect(coinChange([1, 2, 5], 3)).toEqual(2)
  })
  test('用例二', () => {
    expect(coinChange([2], 3)).toEqual(-1)
  })
 
  test('用例三', () => {
    expect(coinChange([2], 0)).toEqual(0)
  })
  test('用例四', () => {
    expect(coinChange([3,4,6], 8)).toEqual(2)
  })
  test('用例五', () => {
    expect(coinChange([1], 3)).toEqual(3)
  })
  test('用例六', () => {
    expect(coinChange([5], 3)).toEqual(-1)
  })
  test('用例七', () => {
    expect(coinChange([3,2], 8)).toEqual(3)
  })
})
