/**
 * 你发现了一个装着纸条的宝盒。要打开盒子，你需要找到藏在纸条里的号码。看看这张纸条，破解密码!
 * 如果没有找到其他解决方案，N.B. Answers应该返回0 !
 * 
 * examples
 *    test("The robins love hiding amongst the smooth reeds") //3---smoo_th ree_ds
 * 
 *    test(It's always worth looking after your friends, even if they've upset you) 
 *    // 7---friend_s, even_
 * 
 *    test("To avoid the calf, I veered sharply to the left"). // 5---cal_f, I ve_ered
 * 
 * https://www.codewars.com/kata/59da98e86ecd95f06000073d/train/javascript
 * */

// answer
const findNum =
  s => [
    'zero', 'one', 'two',
    'three', 'four', 'five',
    'six', 'seven', 'eight',
    'nine', 'ten'
  ]
    .reduce((p, c, i) => s.replace(/[^a-zA-Z]/g, '').toLowerCase().search(c) >= 0 ? i : p, 0)