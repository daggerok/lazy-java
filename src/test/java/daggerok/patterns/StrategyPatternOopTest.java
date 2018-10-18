package daggerok.patterns;

import daggerok.patterns.StrategyPatternOop.UahToUsdConverter;
import daggerok.patterns.StrategyPatternOop.UsdToUahConverter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StrategyPatternOopTest {

  static int calculateImperative(final List<Integer> ints,
                                 final Predicate<Integer> predicate) {
    int acc = 0;
    for (final Integer i : ints) {
      if (predicate.test(i)) {
        acc += i;
      }
    }
    return acc;
  }

  @Test
  @DisplayName("test imperative like approach")
  void testImperative() {

    final List<Integer> ints = IntStream.rangeClosed(0, 10)
                                        .boxed()
                                        .collect(toList());

    assertEquals(55, calculateImperative(ints, i -> true));
    assertEquals(30, calculateImperative(ints, i -> i % 2 == 0));
  }

  @Test
  @DisplayName("OOP test USD -> UAH: 1 usd == 28.01 uah")
  void should_convert_usd_to_uah() {
    assertThat(new UsdToUahConverter().convert(BigDecimal.ONE))
        .isEqualTo(new BigDecimal("28.01"));
    assertThat(new UsdToUahConverter().convert(new BigDecimal(1000)))
        .isEqualTo(new BigDecimal("28010.00"));
  }

  @Test
  @DisplayName("OOP test UAH -> USD: 2801 uah == 100 usd")
  void should_convert_uah_to_usd() {
    assertThat(new UahToUsdConverter().convert(new BigDecimal(280.10)))
        .isEqualTo(new BigDecimal("10.00"));
  }
}
