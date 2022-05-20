/**
 * 
 * 使用正则将数字替换
 * https://www.codewars.com/kata/57e1e61ba396b3727c000251/train/javascript
 * */
function stringClean(s) {
  return s.replace(/\d/g, "")
}