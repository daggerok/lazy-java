package daggerok.vavr.plain;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.util.function.BiFunction;

@Slf4j
public class ChackedFunctions {

  private ChackedFunctions() {}

  public static final BiFunction<String, String, String>
      ckecked = (one, two) -> wrapThrow(one) + wrapThrow(two);

  @SneakyThrows
  public static String wrapThrow(final String string) {
    return couldThrow(string);
  }

  public static String couldThrow(final String string) throws Exception {
    return string;
  }
}
