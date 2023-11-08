/**
 * https://leetcode.cn/problems/palindrome-number/
 * 回文数
 * @param {number} x
 * @return {boolean}
 */
export const isPalindrome = function (x) {
  if (x < 0) {
    return false
  } else if (x < 10) {
    return true
  } else {
    const str = x + ""
    let len = str.length
    for (let i = 0; i < len / 2; i++) {
      if (str[i] !== str[len - i - 1]) {
        return false
      }
    }
    return true
  }
};

export const isPalindromeBetter = (num) => {
   /*
    为什么性能要好些
    if (num < 0) return false
    let x = 0
    let y = num
    while (y !== 0) {
      x = x * 10 + y % 10
      y = Math.floor(y / 10)
    }
    return x === num
  */
  
  if (num < 0) return false
  let x = 0, y = num
  while (y > 0) {
    x = x * 10 + y % 10
    y = Math.floor(y / 10)
  }
  return num === 0 || x === num
}


const isPalindromeBest = (x) => {
  x = x + "";
  const len = x.length;
  for (let i = 0, j = len - 1; i < j; i++, j--) {
    if (x[i] !== x[j]) {
      return false;
    }
  }
  return true;
}
