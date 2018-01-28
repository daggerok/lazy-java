package daggerok;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@DisplayName("JUnit 5 modern tests") class TernaryLazyEvaluatedOperatorTest {

  <T> T ternary(boolean pred, Supplier<T> one, Supplier<T> two) {
    return pred ? one.get() : two.get();
  }

  String one() {
    return "one";
  }

  String two() {
    return "two";
  }

  @Test
  void test() {

    String res = ternary(true, () -> one(), () -> two());
    assertEquals("one", res);
  }
}
