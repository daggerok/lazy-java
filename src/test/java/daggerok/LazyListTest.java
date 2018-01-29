package daggerok;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
class LazyListTest {

  @Test
  @DisplayName("test my lazy..")
  void head() {

    final LazyList<Integer> numbers = HeadTailLazyListImpl.from(2);

    final Integer one = HeadTailLazyListImpl.primeNumbers(numbers).head();
    log.info("\n1st: {}", one);

    final Integer two = HeadTailLazyListImpl.primeNumbers(numbers).tail().head();
    log.info("\n2nd: {}", two);

    final Integer three = HeadTailLazyListImpl.primeNumbers(numbers).tail().tail().head();
    log.info("\n2nd: {}", three);
  }
}
