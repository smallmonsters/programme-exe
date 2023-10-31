import {deleteArr, demo, inset} from "../src/scattered";

test('从数组中找到重复的数', () => {
  expect(demo([1, 2, 3, 4, 5, 3])).toBe(3);
})


describe('不使用Array原生方法，实现一些数组方法', () => {
  test('实现数组中间插入用例一', () => {
    expect(inset(2, "t", ['a', 'b', 'c', 'd'])).toStrictEqual(['a', 'b', 't', 'c', 'd'])
  })
  
  test('实现数组中间插入用例二', () => {
    expect(inset(3, "t", ['a', 'b', 'c', 'd'])).toStrictEqual(['a', 'b', 'c', 't', 'd'])
  })
  test("实现数组delete用例一", () => {
    expect(deleteArr(2, [1, 2, 3, 4, 5]).filter(v => v)).toStrictEqual([1, 2, 4, 5])
  })
});

