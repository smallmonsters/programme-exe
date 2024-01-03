import {strStr} from "../../src/leetcode/strStr";

describe(' 找出字符串中第一个匹配项的下标', () => {
  test('用例一', () => {
    expect(strStr("sadbutsad","sad")).toEqual(0)
  })
  test('用例二', () => {
    expect(strStr("leetcode","leeto")).toEqual(-1)
  })
  // test('用例三', () => {
  //   expect(strStr("IX")).toEqual(9)
  // })
  // test('用例四', () => {
  //   expect(strStr("MDCCCLXXXIV")).toEqual(1884)
  // })
  // test('用例五', () => {
  //   expect(strStr("MCDLXXVI")).toEqual(1476)
  // })
  // test('用例六', () => {
  //   expect(strStr("MMC")).toEqual(2100)
  // })
  // test('用例七', () => {
  //   expect(strStr("MCM")).toEqual(1900)
  // })
})
