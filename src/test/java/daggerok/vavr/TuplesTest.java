package daggerok.vavr;

import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.collection.Seq;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.BiFunction;

import static java.lang.String.format;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("tuples tests")
class TuplesTest {

  @Test
  void test() {

    final Tuple2<String, Integer> java = Tuple.of("java", 8);
    final Seq<?> seq = java.toSeq();
    assertEquals("java", seq.get(0));
    assertEquals(8, seq.apply(1));

    final Tuple2<String, Integer> vavr = java.map(k -> "vavr", v -> 0);
    final String vavr0 = vavr.apply((k, v) -> k + v);
    assertEquals("vavr0", vavr0);
  }
}
