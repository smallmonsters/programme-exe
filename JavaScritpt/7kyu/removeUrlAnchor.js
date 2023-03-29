/**
 * 移除url锚点(#)后的内容
 * https://www.codewars.com/kata/51f2b4448cadf20ed0000386/train/javascript
 * */
function removeUrlAnchor(url) {
  return url.replace(/([\w\d\\\?\&\_\-\.]*)#([\w\d\\\?\&\_\-]*)/, "$1")
}
// better
function removeUrlAnchor(url) {
  return url.replace(/#.*/ig, "");
}

console.log(removeUrlAnchor("https://www.rat.int#"));

