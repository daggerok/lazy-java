package daggerok.vavr.onsteroids;

import io.vavr.Function2;
import io.vavr.control.Option;

public class PartialsLifting {

  private PartialsLifting() {}

  public static final Function2<Integer, Integer, Integer>
      div = (a, b) -> a / b;

  public static final Function2<Integer, Integer, Option<Integer>>
      lift =Function2.lift(div);
}
