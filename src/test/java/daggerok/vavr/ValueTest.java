package daggerok.vavr;

import io.vavr.Function1;
import io.vavr.control.Option;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("values are: Option, Try, Lazy, Either, Future, Validation, Collections API")
class ValueTest {

  @Test
  @DisplayName("testing plain Optional")
  void optional() {

    Function1<Object, String> stringify = in -> Optional.ofNullable(in)
                                                        .map(String::valueOf)
                                                        .map(String::toUpperCase)
                                                        .orElse("NONE");

    assertEquals("NONE", stringify.apply(null));
    assertEquals("ABC", stringify.apply("abc"));
    assertEquals("NONE", stringify.apply(Option.none()));
    // vavr toString with ()
    assertEquals("SOME(XYZ)", stringify.apply(Option.of("xyz")));
    // java toString with []
    assertEquals("OPTIONAL[XYZ]", stringify.apply(Optional.of("xyz")));
  }

  @Test
  @DisplayName("testing on steroids Option")
  void option() {

    Function1<Object, String> stringify = in -> Option.of(in)
                                                      .map(String::valueOf)
                                                      .map(String::toUpperCase)
                                                      .getOrElse(() -> "NONE");

    assertEquals("NONE", stringify.apply(null));
    assertEquals("ABC", stringify.apply("abc"));
    assertEquals("NONE", stringify.apply(Option.none()));
    // vavr toString with ()
    assertEquals("SOME(XYZ)", stringify.apply(Option.of("xyz")));
    // java toString with []
    assertEquals("OPTIONAL[XYZ]", stringify.apply(Optional.of("xyz")));
  }
}
