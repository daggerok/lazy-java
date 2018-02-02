package daggerok.patterns;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategyPatternTest {

  static int calculateImperative(final List<Integer> ints,
                                 final Predicate<Integer> predicate) {
    int acc = 0;
    for (final Integer i : ints) {
      if (predicate.test(i)) {
        acc += i;
      }
    }
    return acc;
  }

  @Test @DisplayName("test imperative like approach")
  void testImperative() {

    final List<Integer> ints = IntStream.rangeClosed(0, 10)
                                        .boxed()
                                        .collect(toList());

    assertEquals(55, calculateImperative(ints, i -> true));
    assertEquals(30, calculateImperative(ints, i -> i % 2 == 0));
  }
}
