package daggerok.vavr;

import io.vavr.control.Option;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static daggerok.vavr.onsteroids.PartialsLifting.lift;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("partial functions, lift (lifting) and memoization")
class PartialsLiftingTest {

  @Test
  void test() {

    final Option<Integer> ok = lift.apply(16, 8);
    assertFalse(ok.isEmpty());
    assertEquals(2, ok.get().intValue());

    final Option<Integer> err = lift.apply(1, 0);
    assertThrows(NoSuchElementException.class, err::get, "No value present");
    assertTrue(err.isEmpty());
  }
}
