package daggerok.vavr.onsteroids;

import io.vavr.Function1;
import io.vavr.Function2;

public class Curryings {

  private Curryings() {}

  public static final Function2<Integer, Integer, Integer>
      sum = (a, b) -> a + b;

  public static final Function1<Integer, Function1<Integer, Integer>>
      curried = sum.curried();
}
