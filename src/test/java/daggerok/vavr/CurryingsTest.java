package daggerok.vavr;

import io.vavr.Function1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static daggerok.vavr.onsteroids.Curryings.curried;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("currying tests")
class CurryingsTest {

  @Test
  void test() {

    final Function1<Integer, Integer> add2 = curried.apply(2);
    assertEquals(3, add2.apply(1).intValue());

    final Function1<Integer, Integer> same = curried.apply(0);
    assertEquals(2, same.apply(2).intValue());
  }
}
