import {isPalindrome, isPalindromeBetter} from "../../src/leetcode/isPalindrome";

describe('回文数isPalindrome方法', () => {
  test('用例一: 123', () => {
    expect(isPalindrome(123)).toBeFalsy()
  })
  test('用例二: -121', () => {
    expect(isPalindrome(-121)).toBeFalsy()
  })
  test('用例三: 9', () => {
    expect(isPalindrome(9)).toBeTruthy()
  })
  test('用例四: 123456654321', () => {
    expect(isPalindrome(123456654321)).toBeTruthy()
  })
  test('用例五: 1234567654321', () => {
    expect(isPalindrome(1234567654321)).toBeTruthy()
  })
  test('用例流: 10', () => {
    expect(isPalindrome(10)).toBeFalsy()
  })
})
describe('回文数isPalindromeBetter方法', () => {
  test('用例一: 123', () => {
    expect(isPalindromeBetter(123)).toBeFalsy()
  })
  test('用例二: -121', () => {
    expect(isPalindromeBetter(-121)).toBeFalsy()
  })
  test('用例三: 9', () => {
    expect(isPalindromeBetter(9)).toBeTruthy()
  })
  test('用例四: 123456654321', () => {
    expect(isPalindromeBetter(123456654321)).toBeTruthy()
  })
  test('用例五: 1234567654321', () => {
    expect(isPalindromeBetter(1234567654321)).toBeTruthy()
  })
  test('用例流六: 10', () => {
    expect(isPalindromeBetter(10)).toBeFalsy()
  })
  test('用例流七: 0', () => {
    expect(isPalindromeBetter(0)).toBeTruthy()
  })
})
