package daggerok.functional;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class AnotherResourceHandling {

  public static class MyResource {
    // business-logic
    public static List<String> readLinesOf(final String filename,
                                           final Predicate<String> selector) {
      return withLinesOf(filename,
                         lines -> lines.filter(selector)
                                       .collect(toList()),
                         RuntimeException::new);
    }

    // infrastructure
    private static <T> T withLinesOf(final String filepath,
                                     final Function<Stream<String>, T> handler,
                                     final Function<Throwable, RuntimeException> error) {

      try (final BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
        return handler.apply(reader.lines());
      } catch (IOException e) {
        throw error.apply(e);
      }/* finally {
        // close / cleanup resource...
      }*/
    }
  }
}
