/**
 * 
 * 编写一个函数，从字符串中删除所有非数字字符并将剩余的字符解析为数字
 * E.g: "hell5o wor6ld" -> 56
 * https://www.codewars.com/kata/57a37f3cbb99449513000cd8/train/javascript
 * */

function getNumberFromString(s) {
  return Number(s.replace(/\D/g, ''));
}

