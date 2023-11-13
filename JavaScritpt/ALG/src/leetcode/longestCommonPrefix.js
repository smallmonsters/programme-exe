/**
 * https://leetcode.cn/problems/longest-common-prefix/
 * 最长公共前缀
 * @param {string[]} strs
 * @return {string}
 */
export const longestCommonPrefix = function (strs) {
  let pre = strs[0]
  let next = ""
  for (let i = 1; i < strs.length; i++) {
    next = ''
    for (let j = 0; j < strs[i].length; j++) {
      const s = strs[i][j]
      if (s !== pre[j] || s === undefined) break
      next += s
    }
    pre = next
  }
  return pre
};


const longestCommonPrefixBySort = function(strs) {
  strs.sort();
  for (let i = 0; i < strs[0].length; i++) {
    if (strs[0][i] !== strs[strs.length - 1][i]) return strs[0].substr(0, i);
  }
  return strs[0];
};
