# [twoSum](./twoSum.js)

字典或者Map查找速度O(1)

# [isPalindrome](./isPalindrome.js)

## 取模

- `x%10`，可得末位 1。
- 任何有模的计量器，均可化为加减法运算

  >例如： 假设当前时针指向10点,而准确时间是6点,调整时间可有以下两种拨法：  
  >一种是倒拨4小时,即：10-4=6  
  >另一种是顺拨8小时：10+8=12+6 =6  
  >在以12模的系统中,加8和减4效果是一样的,因此凡是减4运算,都可以用加8来代替.  
- 计算机中取模的应用思想
  
  取模的本质是：取模的值，必定会模的范围内；所以，计算机领域引用该特性，使元素路由算法不超出边界，并有规则存放。

- 应用
  - 判断奇偶性：x % 2 == 0
  - 对数组下标的取模处理来实现循环：（(tail+1)%n==head）
  - 取一个数的最低位：

    取这个数与10^n的模数，其中n是你想要获取的最低位数。例如，如果你想获取一个数的最后5位，你可以取这个数与10^5的模数。

## Manacher 算法

todo:

# [mergeTwoLists](./mergeTwoLists.js)

递归、指针、链表
