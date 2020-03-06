/**
对一段文字内的单词内部进行降序排序

1、对一段文字内的单词内部进行降序排序
2、单词内部不包括首字母和最后一个字母

examples
  "sort the inner content in descending order" -> "srot the inner ctonnet in dsnnieedcg oredr"
  "wait for me" -> "wiat for me"
  "this kata is easy" -> "tihs ktaa is esay"

  words不会为null或空字符，只有小写字母和空格

https://www.codewars.com/kata/5898b4b71d298e51b600014b/train/javascript

**/


// my answer
function sortTheInnerContent(words) {
  return words.split(" ").map(v => {
    const innerOld = v.slice(1, v.length - 1)
    const innerNew = innerOld.split("").sort((a, b) => b.charCodeAt() - a.charCodeAt()).join("")
    const reg = new RegExp(innerOld)
    return v.replace(reg, innerNew)
  }).join(" ")
}

// best answer

function sortTheInnerContent(words){
  return words.replace(/\B\w+(?=\w)/g, x => x.split('').sort().reverse().join(''));
}