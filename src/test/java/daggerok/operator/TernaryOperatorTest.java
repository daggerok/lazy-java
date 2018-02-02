package daggerok.operator;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@DisplayName("JUnit 5 modern tests") class TernaryOperatorTest {

  <T> T ternary(boolean pred, T one, T two) {
    return pred ? one : two;
  }

  String one() {
    return "one";
  }

  String two() {
    return "two";
  }

  @Test
  void test() {

    String res = ternary(true, one(), two());
    assertEquals("one", res);
  }
}
