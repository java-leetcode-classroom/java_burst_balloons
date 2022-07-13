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
  public int maxCoinsDFS(int[] nums) {
    int numLen = nums.length;
    int[] bufferNums = new int[numLen+2];
    bufferNums[0] = 1;
    bufferNums[numLen+1] = 1;
    for (int idx = 0; idx < numLen; idx++) {
      bufferNums[idx+1] = nums[idx];
    }
    int[][] cache = new int[numLen+2][numLen+2];
    return dfs(1, numLen, bufferNums, cache);
  }
  public int dfs(int left, int right, int[] bufferNums, int[][] cache) {
    if (left > right) {
      return 0;
    }
    if (cache[left][right] != 0) {
      return cache[left][right];
    }
    for (int pivot = left; pivot <= right; pivot++) {
      int coins = bufferNums[left-1] * bufferNums[pivot] * bufferNums[right+1];
      coins += dfs(left, pivot-1, bufferNums, cache) + dfs(pivot+1, right, bufferNums, cache);
      cache[left][right] = Math.max(cache[left][right], coins);
    }
    return cache[left][right];
  }
}
