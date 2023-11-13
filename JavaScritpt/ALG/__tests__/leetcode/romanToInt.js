import {romanToInt} from "../../src/leetcode/romanToInt";

describe(' 罗马数字转整数', () => {
  test('用例一', () => {
    expect(romanToInt("MCMXCIV")).toEqual(1994)
  })
  test('用例二', () => {
    expect(romanToInt("LVIII")).toEqual(58)
  })
  test('用例三', () => {
    expect(romanToInt("IX")).toEqual(9)
  })
  test('用例四', () => {
    expect(romanToInt("MDCCCLXXXIV")).toEqual(1884)
  })
  test('用例五', () => {
    expect(romanToInt("MCDLXXVI")).toEqual(1476)
  })
  test('用例六', () => {
    expect(romanToInt("MMC")).toEqual(2100)
  })
  test('用例七', () => {
    expect(romanToInt("MCM")).toEqual(1900)
  })
})
