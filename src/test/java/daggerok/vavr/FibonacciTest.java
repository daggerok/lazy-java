package daggerok.vavr;

import io.vavr.Function1;
import io.vavr.collection.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("vavronacci")
class FibonacciTest {

  @Test
  @DisplayName("test fibonacci")
  void test() {

    Function1<Integer, Stream> fibonacci =
        n -> Stream.of(1, 1)
                   .appendSelf(self -> self.zip(self.tail())
                                           .map(t -> t._1 + t._2))
                   .take(n)
                   .orElse(Stream.of(0)) // zero fallback
        ;

    assertEquals(0, fibonacci.apply(-10).last());
    assertEquals(0, fibonacci.apply(0).last());
    assertEquals(1, fibonacci.apply(1).last());
    assertEquals(1, fibonacci.apply(2).last());
    assertEquals(2, fibonacci.apply(3).last());
    assertEquals(3, fibonacci.apply(4).last());
    assertEquals(5, fibonacci.apply(5).last());
    assertEquals(8, fibonacci.apply(6).last());
    assertEquals(13, fibonacci.apply(7).last());
  }
}
