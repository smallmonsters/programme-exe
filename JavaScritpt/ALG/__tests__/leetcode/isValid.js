import {isValid} from "../../src/leetcode/isValid";

describe('有效的括号', () => {
  test('用例一', () => {
    expect(isValid("{}")).toBeTruthy()
  })
  test('用例二', () => {
    expect(isValid("{)")).toBeFalsy()
  })
  test('用例三', () => {
    expect(isValid("{}()[]")).toBeTruthy()
  })
  test('用例四', () => {
    expect(isValid("{[]}")).toBeTruthy()
  })
  test('用例五', () => {
    expect(isValid("(])")).toBeFalsy()
  })
})
