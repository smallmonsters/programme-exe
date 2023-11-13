/**
 * https://leetcode.cn/problems/valid-parentheses/description/
 * 有效的括号
 * @param {string} s
 * @return {boolean}
 */
export const isValid = function (s) {
  const stack = []
  for (let i = 0; i < s.length; i++) {
    if (s[i] === '(' || s[i] === '{' || s[i] === '[') {
      stack.push(s[i])
    } else {
      if (stack.length === 0) return false
      if (s[i] === ')' && stack[stack.length - 1] === '(') {
        stack.pop()
        continue
      }
      if (s[i] === '}' && stack[stack.length - 1] === '{') {
        stack.pop()
        continue
      }
      if (s[i] === ']' && stack[stack.length - 1] === '[') {
        stack.pop()
        continue
      }
      return false
    }
  }
  return stack.length === 0
}

// better
const isValidBetter = function (s) {
  const stack = [], map = {
    '(': ")",
    '[': "]",
    '{': "}"
  }
  for (const char of s) {
    if (char in map) {
      stack.push(char)
      continue;
    }
    if (map[stack.pop()] !== char) return false
  }
  return !stack.length
};
