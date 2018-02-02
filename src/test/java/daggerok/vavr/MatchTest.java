package daggerok.vavr;

import io.vavr.API;
import io.vavr.Function1;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static io.vavr.API.$;
import static io.vavr.API.Case;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MatchTest {

  @Test @DisplayName("pattern matching or switch-case on steroids")
  void patternMatching() {

    Function1<Integer, String> translate =
        i -> API.Match(i).of(
            Case($(1), "One"),
            Case($(2), "Two"),
            Case($(3), "Three"),
            Case($(), "Whatever")
        );

    assertEquals("One", translate.apply(1));
    assertEquals("Whatever", translate.apply(-1));
  }

  @Test @DisplayName("I need more")
  void anotherMatch() {

    Function1<Integer, String> translate =
        i -> API.Match(i).of(
            Case($(x -> x % 2 == 0), "Even"),
            Case($(x -> x % 2 == 1), "Odd"),
            Case($(), "?")
        );

    assertEquals("Even", translate.apply(2));
    assertEquals("Odd", translate.apply(3));
    assertEquals("?", translate.apply(-333));
  }

  @Test @DisplayName("More!!111111oneoneone")
  void dates() {

    Function1<LocalDate, String> date =
        i -> API.Match(i).of(
            Case($(LocalDate.of(2001, 01, 01)), () -> "2001-01-01"),
            Case($(), () -> "I don't care...")
        );

    assertEquals("I don't care...", date.apply(LocalDate.now()));
    assertEquals("2001-01-01", date.apply(LocalDate.of(2001, 01, 01)));
  }
}
