/**
 * 322. 零钱兑换
 * https://leetcode.cn/problems/coin-change/
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 * startTime:忘了
 * endTime: 2024/01/10
 */
// 参考别人java的解法，用ai改的
/**
 * 思路：
 * 从1到amount，遍历每一个数i
 * 每一个数i都到coins中找，如果找到
 * */
export const coinChange = function (coins, amount) {
  if (amount === 0) return 0;
  
  let dp = new Array(amount + 1).fill(-1);  // 初始化dp数组，初始值为-1
  dp[0] = 0;
  
  for (let i = 1; i <= amount; i++) {
    let min = Number.MAX_SAFE_INTEGER;
    for (let c of coins) {
      if (i - c >= 0 && dp[i - c] !== -1) {
        // 核心代码，自己根本想不到求最小值是min和dp[i-c]
        min = Math.min(min, dp[i - c]);
      }
    }
    if (min !== Number.MAX_SAFE_INTEGER) {
      dp[i] = min + 1;
    }
  }
  return dp[amount];
};
