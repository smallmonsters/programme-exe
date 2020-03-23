/**
 * 把每个单词的第一个字母移到它的末尾，然后在单词的末尾加上“ay”。不要动标点符号。
 * 
 * examples
 *     pigIt('Pig latin is cool'); // igPay atinlay siay oolcay
 *     pigIt('Hello world !');     // elloHay orldway !
 * 
 * https://www.codewars.com/kata/520b9d2ad5c005041100000f/train/javascript
 * */



//  my answer
function pigIt(str) {
  return str.split(" ").map(v => {
    const first = v[0]
    if (/[^A-z]/.test(v)) return " "+v
    return v.replace(v[0], " ") + first + "ay"
  }).join("").trim()
}


// better
function pigIt(str) {
  return str.replace(/\w+/g, (w) => {
    return w.slice(1) + w[0] + 'ay';
  });
}
// Best Practices
function pigIt(str){
  return str.replace(/(\w)(\w*)(\s|$)/g, "\$2\$1ay\$3")
}

