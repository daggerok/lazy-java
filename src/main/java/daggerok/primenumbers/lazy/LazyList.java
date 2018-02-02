package daggerok.primenumbers.lazy;

import java.util.function.Predicate;

public interface LazyList<T> {

  T head();

  LazyList<T> tail();

  LazyList<T> filter(Predicate<T> predicate);

  boolean isEmpty();
}
