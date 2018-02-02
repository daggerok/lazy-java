package daggerok.vavr.onsteroids;

import io.vavr.CheckedFunction2;

public class ChackedFunctions {

  private ChackedFunctions() {}

  public static final CheckedFunction2<String, String, String>
      ckecked = (one, two) -> couldThrow(one) + couldThrow(two);

  public static String couldThrow(final String string) throws Exception {
    return string;
  }
}
