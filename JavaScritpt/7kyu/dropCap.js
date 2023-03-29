/**
 * 首写字母大写，忽略两个字母的
 * https://www.codewars.com/kata/559e5b717dd758a3eb00005a/javascript
 * */
function dropCap(n) {
  return n.replace(/(?<![^a-z\s,][a-z]*)(?![a-z]*[^a-z\s,])([a-z])([a-z]{2,})(\s*)/gmi, (_, $1, $2, $3) => $1.toUpperCase() + $2.toLowerCase() + $3)
}