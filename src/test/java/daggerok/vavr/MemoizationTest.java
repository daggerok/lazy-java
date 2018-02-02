package daggerok.vavr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static daggerok.vavr.onsteroids.Memoization.memoizedRandom;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("memoization, yeah!")
class MemoizationTest {

  @Test
  @DisplayName("testing cache")
  void test() {

    final Double brokenRandom = memoizedRandom.get();

    assertEquals(brokenRandom, memoizedRandom.get());
    assertEquals(brokenRandom, memoizedRandom.get());
    assertTrue(brokenRandom < 1.0d);
    assertTrue(brokenRandom > 0);
  }
}
