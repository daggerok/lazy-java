package daggerok;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@DisplayName("JUnit 5 modern tests")
class BadPrimesTest {

  static IntStream primeNumbers(final int n) {
    return IntStream.iterate(2, i -> i + 1)
                    .filter(BadPrimesTest::isPrime)
                    .limit(n);
  }

  private static boolean isPrime(final int candidate) {
    return candidate >= 2 && IntStream.rangeClosed(2, (int) Math.sqrt(candidate))
                                      .noneMatch(i -> candidate % i == 0);
  }

  @Test
  @DisplayName("is prime")
  void test3() {

    assertAll("testing primes...",
              () -> assertFalse(isPrime(0)),
              () -> assertFalse(isPrime(1)),
              () -> assertFalse(isPrime(4)),
              () -> assertTrue(isPrime(2)),
              () -> assertTrue(isPrime(3)),
              () -> assertTrue(isPrime(5)));

    log.info("firrst 10 prime numbers: {}", primeNumbers(10).mapToObj(String::valueOf)
                                                            .collect(toList()));
  }
}
