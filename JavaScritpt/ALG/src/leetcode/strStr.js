/**
 *  找出字符串中第一个匹配项的下标
 * https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
export const strStr = function (haystack, needle) {
  if (needle.length > haystack.length) return -1
  let index = -1
  for (let i = 0; i < haystack.length; i++) {
    for (let j = 0; j < needle.length; j++) {
      if (needle[j] !== haystack[i + j]) {
        index = -1
        break;
      }
      index = j
    }
    if (index !== -1 && index < needle.length) {
      index = i
      break
    }
  }
  return index
};
