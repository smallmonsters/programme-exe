/**
 * 编写一个简单的正则表达式来验证用户名。允许的字符是：
 * 小写字母，数字，下划线，长度应介于 4 到 16 个字符之间（均包含在内
 * https://www.codewars.com/kata/56a3f08aa9a6cc9b75000023/train/javascript
 * */

function validateUsr(username) {
  res = /^[0-9a-z_]{4,16}$/.test(username)
  return res
}