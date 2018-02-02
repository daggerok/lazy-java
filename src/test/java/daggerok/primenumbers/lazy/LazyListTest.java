package daggerok.primenumbers.lazy;

import daggerok.extensions.CaptureSystemOutput;
import lombok.extern.slf4j.Slf4j;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.*;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@CaptureSystemOutput
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

  @Test @DisplayName("iterative print")
  void printAllByIterationTest(CaptureSystemOutput.OutputCapture log) {
    log.expect(CoreMatchers.containsString("1: 2"));
    log.expect(CoreMatchers.containsString("2: 3"));
    log.expect(CoreMatchers.containsString("3: 5"));

    HeadTailLazyListImpl.printAllByIteration(10);

    assertTrue(log.toString().contains("4: 7"));
    ////this will fail, just uncomment to check
    //assertTrue(log.toString().contains("5: 9"));
    assertTrue(log.toString().contains("5: 11"));
  }

  @Test @DisplayName("reverse recursive print")
  void reversePrintByRecursionTest(CaptureSystemOutput.OutputCapture log) {

    final Function<LazyList<Integer>, LazyList<Integer>> prime = HeadTailLazyListImpl::primeNumbers;
    final LazyList<Integer> numbers = HeadTailLazyListImpl.from(2);

    log.expect(CoreMatchers.containsString("10: 2"));
    log.expect(CoreMatchers.containsString("9: 3"));
    log.expect(CoreMatchers.containsString("8: 5"));

    HeadTailLazyListImpl.reversePrintByRecursion(prime.apply(numbers), 10);

    assertTrue(log.toString().contains("7: 7"));
    ////this will fail, just uncomment to check
    //assertTrue(log.toString().contains("6: 9"));
    assertTrue(log.toString().contains("6: 11"));
  }
}
