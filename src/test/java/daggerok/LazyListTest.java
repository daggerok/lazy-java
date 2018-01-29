package daggerok;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class LazyListTest {

  @Test
  @DisplayName("test my lazy..")
  void head() {

    final Function<LazyList<Integer>, LazyList<Integer>> prime = HeadTailLazyListImpl::primeNumbers;
    final LazyList<Integer> numbers = HeadTailLazyListImpl.from(2);

    final int first = prime.apply(numbers).head();
    assertEquals(2, first);

    final int second = prime.apply(numbers).tail().head();
    assertEquals(3, second);

    final int third = prime.apply(numbers).tail().tail().head();
    assertEquals(5, third);
  }
}
