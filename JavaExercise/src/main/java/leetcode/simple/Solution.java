package leetcode.simple;

/**
 * https://leetcode.cn/problems/search-insert-position/
 * 搜索插入位置
 */
public class Solution {
  public static void main(String[] args) {
    int a = (4 + 2) / 2;
    System.out.println(a);
  }

  public int searchInsert(int[] nums, int target) {
    int i = 0;
    while (i < nums.length) {
      if (nums[i] == target || nums[i] > target) break;
      if (i < nums.length - 1 && nums[i] < target && nums[i + 1] > target) {
        i++;
        break;
      }
      i++;
    }
    return i;
  }

  //  Better: 二分法
  public int searchInsertBetter(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return left;
  }
}
