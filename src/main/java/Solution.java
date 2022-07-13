public class Solution {
  public int maxCoins(int[] nums) {
    int numLen = nums.length;
    int[] bufferNums = new int[numLen+2];
    bufferNums[0] = 1;
    bufferNums[numLen+1] = 1;
    for (int idx = 0; idx < numLen; idx++) {
      bufferNums[idx+1] = nums[idx];
    }
    // dp[L][R]
    int[][] dp = new int[numLen+2][numLen+2];
    for (int left = numLen; left >= 1; left--) {
      for (int right = left; right <= numLen; right++) {
        dp[left][right] = 0;
        for (int pivot = left ; pivot <= right; pivot++) {
          int coins = bufferNums[left-1]*bufferNums[pivot]*bufferNums[right+1] + dp[left][pivot-1] + dp[pivot+1][right];
          dp[left][right] = Math.max(dp[left][right], coins);
        }
      }
    }
    return dp[1][numLen];
  }
}
