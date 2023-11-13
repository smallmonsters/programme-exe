/**
 * https://leetcode.cn/problems/roman-to-integer/
 * 罗马数字转整数
 * @param {string} s
 * @return {number}
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 *
 */
export const romanToInt = function (s) {
  const map = new Map([
    ['I', 1],
    ['V', 5],
    ['X', 10],
    ['L', 50],
    ['C', 100],
    ['D', 500],
    ['M', 1000]
  ])
  let sum = 0
  for (let i = 0; i < s.length; i++) {
    debugger
    if (s[i] === 'I' && s[i + 1] === 'V') {
      sum += 4
      i++
    } else if (s[i] === 'I' && s[i + 1] === 'X') {
      sum += 9
      i++
    } else if (s[i] === 'X' && s[i + 1] === 'L') {
      sum += 40
      i++
    } else if (s[i] === 'X' && s[i + 1] === 'C') {
      sum += 90
      i++
    } else if (s[i] === 'C' && s[i + 1] === 'D') {
      sum += 400
      i++
    } else if (s[i] === 'C' && s[i + 1] === 'M') {
      sum += 900
      i++
    } else {
      sum += map.get(s[i])
    }
  }
  return sum
};
