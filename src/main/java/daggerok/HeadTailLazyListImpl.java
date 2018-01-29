package daggerok;

import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.function.Predicate;
import java.util.function.Supplier;

@ToString
@RequiredArgsConstructor
public class HeadTailLazyListImpl<T> implements LazyList<T> {

  private final T head;
  private final Supplier<LazyList<T>> tail;

  @Override public T head() {
    return head;
  }

  @Override public LazyList<T> tail() {
    return tail.get();
  }

  @Override public LazyList<T> filter(final Predicate<T> predicate) {

    return
        isEmpty()
            ? this
            : predicate.test(head())
            ? new HeadTailLazyListImpl<>(head(),
                                         () -> tail().filter(predicate))
            : tail().filter(predicate)
        ;
  }

  @Override public boolean isEmpty() {
    return false;
  }

  public static LazyList<Integer> from(final int n) {
    return new HeadTailLazyListImpl<>(n, () -> from(n + 1));
  }

  public static LazyList<Integer> primeNumbers(final LazyList<Integer> numbers) {

    return new HeadTailLazyListImpl<>(numbers.head(),
                                      () -> primeNumbers(numbers.tail()
                                                                .filter(i -> i % numbers.head() != 0)));
  }
}
