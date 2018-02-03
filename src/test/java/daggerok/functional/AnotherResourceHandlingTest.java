package daggerok.functional;

import daggerok.extensions.CaptureSystemOutput;
import daggerok.extensions.CaptureSystemOutput.OutputCapture;
import daggerok.functional.AnotherResourceHandling.MyResource;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

import static junit.framework.TestCase.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.MatcherAssert.*;

@CaptureSystemOutput
class AnotherResourceHandlingTest {

  @Test
  @SneakyThrows
  @DisplayName("one more resource management..")
  void testMyResource(final OutputCapture out) {

    final URI uri = Objects.requireNonNull(
        AnotherResourceHandlingTest.class.getClassLoader()
                                         .getResource("test.txt")).toURI();

    final String filepath = Paths.get(uri)
                          .toAbsolutePath()
                          .toString();

    final List<String> strings = MyResource.readLinesOf(filepath, s -> s.toLowerCase().contains("err"));

    assertTrue("not less than 3 items.", strings.size() < 3);
    strings.forEach(System.out::println);
    out.expect(containsString("ERROR"));

    final List<String> all = MyResource.readLinesOf(filepath, s -> true);

    assertTrue(all.size() > 20);
    strings.forEach(System.out::println);
  }
}
