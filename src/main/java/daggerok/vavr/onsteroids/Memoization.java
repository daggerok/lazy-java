package daggerok.vavr.onsteroids;

import io.vavr.Function0;
import io.vavr.Function2;

public class Memoization {

  private Memoization() {}

  static final Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
  public static final Function2<Integer, Integer, Integer> memoizedSum = sum.memoized();

  static final Function0<Double> random = Function0.of(Math::random);
  public static final Function0<Double> memoizedRandom = random.memoized();
}
