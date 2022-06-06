/**
 * 给定一个由数字、字母、符号组成的随机字符串，您需要对字符串中的数字求和。
 * 笔记：
 * 连续整数应被视为单个数字。例如，2015 应该被视为一个数字 2015，而不是四个数字
 * 所有数字都应视为正整数。例如，11-14 应视为两个数字 11 和 14。与 3.14 相同，应视为两个数字 3 和 14
 * 如果字符串中没有给出数字，它应该返回 0
 * https://www.codewars.com/kata/55da6c52a94744b379000036/javascript
 * */

function sumFromString(str) {
  return (str.match(/\d+/g) || []).reduce((a, b) => parseInt(a, 10) + parseInt(b, 10), 0)
}

// special
let sumFromString = (str) => str.split(/[^0-9]+/).reduce((a, b) => +a + +b, 0);

console.log(sumFromString("In 2015, I want to know how much does iPhone 6+ cost?"));
console.log(sumFromString("1+1=2"));
console.log(sumFromString("e=mc^2"));
console.log(sumFromString("123fj312lkj1"));