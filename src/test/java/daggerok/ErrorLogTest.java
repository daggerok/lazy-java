package daggerok;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
@DisplayName("JUnit 5 modern tests")
class ErrorLogTest {

  @SneakyThrows
  static Stream<String> readLinesFrom(final String filePath) {

    final URL resource = ErrorLogTest.class.getClassLoader().getResource(filePath);
    final URI uri = Objects.requireNonNull(resource).toURI();
    final Path path = Paths.get(uri);

    return Files.lines(path);
  }

  @Test
  @DisplayName("read errors from file")
  void test2() {

    final Function<Long, Stream<String>> errorsOf =
        limit -> readLinesFrom("test.txt").filter(line -> line.contains("ERROR"))
                                          .limit(limit);

    assertEquals(2, errorsOf.apply(1000L).count());
  }

  @Test
  @DisplayName("generate log")
  void test1() {

    final Function<Long, IntStream> limitted = limit -> IntStream.iterate(0, i -> i * i + i + 1)
                                                                 //.peek(i -> log.info("peeked: {}", i))
                                                                 .limit(limit);

    limitted.apply(100L).findFirst().ifPresent(i -> assertEquals(0, i));
    assertEquals(1000, limitted.apply(1000L).count());

/*
    assertThrows(StackOverflowError.class, () -> {
      infivinteStream.sum();
    });
*/
  }
}
