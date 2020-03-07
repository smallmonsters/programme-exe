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


// my answer
const replace = (str) => str.replace(/\(\)/, "")

function validParentheses(parens) {
  if (parens === "") return true
  if (!/\(\)/.test(parens)) return false
  return validParentheses(replace(parens))
}

// better answer

function validParentheses(parens){
  var re = /\(\)/;
  while (re.test(parens)) parens = parens.replace(re, "");
  return !parens;
}

// other answer

function validParentheses(parens) {
  var n = 0;
  for (var i = 0; i < parens.length; i++) {
    if (parens[i] == '(') n++;
    if (parens[i] == ')') n--;
    if (n < 0) return false;
  }
  return n == 0;
}