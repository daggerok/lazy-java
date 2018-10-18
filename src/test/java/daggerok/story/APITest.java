package daggerok.story;

import daggerok.story.API.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

class APITest {

  @Test
  @DisplayName("should buy on click")
  void buy() {
    // given
    final List<OrderItem> givenOrderItems = asList(
        OrderItem.of("give me 1"),
        OrderItem.of("give me more...")
    );
    // when
    final Delivery whenDelivery = API.oneClickBuy.apply(
        givenOrderItems
    );
    // then
    final Collection<OrderItem> thenOrderItems = whenDelivery.getOrder().cart.getOrderItems();
    assertThat(thenOrderItems.size()).isEqualTo(2);
    assertThat(thenOrderItems).containsAnyOf(
        givenOrderItems.stream().toArray(OrderItem[]::new)
    );
  }
}
