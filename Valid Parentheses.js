/**
编写一个函数，该函数接受一个圆括号字符串，并确定圆括号的顺序是否有效。
如果字符串有效，函数应该返回true;如果无效，则返回false。

examples
  "()"              =>  true
  ")(()))"          =>  false
  "("               =>  false
  "(())((()())())"  =>  true

https://www.codewars.com/kata/52774a314c2333f0a7000688/train/javascript
*/

const replace = (str) => str.replace(/\((.*)\)/, (matchm, p1) => p1)

function validParentheses(parens) {
  if (parens === "") return true
  if (!/\((.*)\)/.test(parens)) return false
  // if (parens !== "") {
  return validParentheses(replace(parens))
  // } else {
  //   return true
  // }
}


function validParentheses(parens) {
  debugger
  if (parens === ")" || parens === "(") return false
  if (parens !== "") {
    return validParentheses(replace(parens))
  } else {
    return true
  }
}

console.log(validParentheses("(())((()())())"))