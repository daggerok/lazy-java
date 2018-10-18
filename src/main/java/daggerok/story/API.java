package daggerok.story;

import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.Singular;
import lombok.Value;

import java.util.Collection;
import java.util.function.Function;

public class API {

  public static final Function<Collection<OrderItem>, Delivery> oneClickBuy =
      ((Function<Collection<OrderItem>, Cart>) API::buy)
          .andThen(API::order)
          .andThen(API::delivery);

  public static Cart buy(final Collection<OrderItem> orderItems) {
    return Cart.builder().orderItems(orderItems).build();
  }

  public static Order order(final Cart cart) {
    return Order.of(cart);
  }

  public static Delivery delivery(final Order orders) {
   return Delivery.with(orders);
  }

  @Value(staticConstructor = "with")
  public static class Delivery {
    @Singular Order order;
  }

  @RequiredArgsConstructor(staticName = "of")
  public static class Order {
    final Cart cart;
  }

  @Value @Builder
  public static class Cart {
    @Singular final Collection<OrderItem> orderItems;
  }

  @RequiredArgsConstructor(staticName = "of")
  public static class OrderItem {
    final String item;
  }

  private API() {}
}
