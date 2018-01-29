package daggerok;

import daggerok.extensions.CaptureSystemOutput;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

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
    log.expect(containsString("1: 2"));
    log.expect(containsString("2: 3"));
    log.expect(containsString("3: 5"));

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

    log.expect(containsString("10: 2"));
    log.expect(containsString("9: 3"));
    log.expect(containsString("8: 5"));

    HeadTailLazyListImpl.reversePrintByRecursion(prime.apply(numbers), 10);

    assertTrue(log.toString().contains("7: 7"));
    ////this will fail, just uncomment to check
    //assertTrue(log.toString().contains("6: 9"));
    assertTrue(log.toString().contains("6: 11"));
  }

/*
  @BeforeEach
  void beforeEach(CaptureSystemOutput.OutputCapture outputCapture) {
    assertFalse(outputCapture.toString().contains("@BeforeEach"));
    System.out.println("@BeforeEach");
    assertTrue(outputCapture.toString().contains("@BeforeEach"));
  }

  @AfterEach
  void afterEach(CaptureSystemOutput.OutputCapture outputCapture) {
    System.out.println("@AfterEach");
    outputCapture.expect(containsString("@BeforeEach"));
    outputCapture.expect(containsString("@AfterEach"));
  }

  @Test
  void systemOut(CaptureSystemOutput.OutputCapture outputCapture) {
    outputCapture.expect(containsString("SYS_OUT #1"));
    System.out.println("Printed to SYS_OUT #1");
    // The following would cause the test to fail after the
    // test method completes.
    // outputCapture.expect(containsString("Foo!"));
  }

  @Test
  void systemErr(CaptureSystemOutput.OutputCapture outputCapture) {
    outputCapture.expect(containsString("SYS_ERR #2"));
    System.err.println("Printed to SYS_ERR #2");
  }

  @Test
  void systemOutAndSystemErr(CaptureSystemOutput.OutputCapture outputCapture) {
    outputCapture.expect(containsString("SYS_OUT #3"));
    outputCapture.expect(containsString("SYS_ERR #3"));
    System.out.println("Printed to SYS_OUT #3");
    System.err.println("Printed to SYS_ERR #3");
  }
*/
}
