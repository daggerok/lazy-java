package daggerok.patterns;

import daggerok.extensions.CaptureSystemOutput;
import daggerok.extensions.CaptureSystemOutput.OutputCapture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.CoreMatchers.containsString;

@CaptureSystemOutput
class IteratorTest {

  @Test
  @DisplayName("external iterator 1")
  void external1(final OutputCapture out) {

    for (int i = 0; i <= 10; i++) {
      System.out.println("out: '" + i + "'");
    }

    out.expect(containsString("out: '10'"));
  }

  @Test
  @DisplayName("external iterator 1")
  void external2(final OutputCapture out) {

    final List<Integer> list = IntStream.rangeClosed(0, 10)
                                        .boxed()
                                        .collect(toList());

    for (int i = 0; i < list.size(); i++) {
      System.out.println("out: '" + list.get(i) + "'");
    }

    out.expect(containsString("out: '10'"));
  }

  @Test
  @DisplayName("internal iterator")
  void internal(final OutputCapture out) {

    Consumer<Integer> internalIetrator =
        size -> IntStream.rangeClosed(0, size)
                         .mapToObj(i -> "out: '" + i + "'")
                         .forEach(System.out::println);

    internalIetrator.accept(10);
    out.expect(containsString("out: '10'"));
  }
}
