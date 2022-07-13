import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
  final private Solution sol = new Solution();
  @Test
  void maxCoinsExamples1() {
    assertEquals(167, sol.maxCoins(new int[]{3,1,5,8}));
  }
  @Test
  void maxCoinsExamples2() {
    assertEquals(10, sol.maxCoins(new int[]{1,5}));
  }

  @Test
  void maxCoinsDFSExamples1() {
    assertEquals(167, sol.maxCoinsDFS(new int[]{3,1,5,8}));
  }
  @Test
  void maxCoinsDFSExamples2() {
    assertEquals(10, sol.maxCoinsDFS(new int[]{1,5}));
  }
}