// https://leetcode.cn/problems/two-sum/
/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
export const twoSum = (nums, target) => {
  for (let i = 0; i < nums.length; i++) {
    for (let j = i + 1; j < nums.length; j++) {
      if (nums[i] + nums[j] === target) return [i, j]
    }
  }
};

// better: 时间复杂度O(n)
const twoSumBetter = function (nums, target) {
  const m = new Map();
  for (let i = 0; ; ++i) {
    const x = nums[i];
    const y = target - x;
    if (m.has(y)) {
      return [m.get(y), i];
    }
    m.set(x, i);
  }
};
