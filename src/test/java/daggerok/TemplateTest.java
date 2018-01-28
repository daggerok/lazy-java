package daggerok;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@DisplayName("JUnit 5 modern tests") class TemplateTest {

  @Test
  @DisplayName("True test")
  void test() {
    assertEquals(true, true);
  }
}
