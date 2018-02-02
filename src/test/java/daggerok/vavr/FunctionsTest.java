package daggerok.vavr;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Functions on steroids")
class FunctionsTest {

  @Test
  void testHollyshit() {
    assertEquals(
        "1234567",
        daggerok.vavr.plain.Functions.functions7(
            "1", "2", "3", "4", "5", "6", "7"
        )
    );
  }

  @Test
  void testOnSteroids() {
    assertEquals(
        "1234567",
        daggerok.vavr.onsteroids.Functions.functions7.apply(
            "1", "2", "3", "4", "5", "6", "7"
        )
    );
  }
}
