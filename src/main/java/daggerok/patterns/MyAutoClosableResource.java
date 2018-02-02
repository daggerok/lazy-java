package daggerok.patterns;

import lombok.ToString;

import java.util.Optional;
import java.util.function.Consumer;

public class MyAutoClosableResource {

  @ToString
  public static class MyResource {
    private boolean closed;
    private String data;
    public static void use(final Consumer<MyResource> consumer) {
      final MyResource resource = new MyResource();
      try {
        consumer.accept(resource);
      }
      finally {
        resource.close();
        System.out.println(resource);
      }
    }
    public MyResource add(final String toBeAdded) {
      this.data = Optional.ofNullable(data).orElse("") + toBeAdded;
      return this;
    }
    public MyResource up() {
      this.data = Optional.ofNullable(data).orElse("").toUpperCase();
      return this;
    }
    public MyResource down() {
      this.data = Optional.ofNullable(data).orElse("").toLowerCase();
      return this;
    }
    private void close() {
      System.out.println("closing..");
      closed = true;
      System.out.println("closed");
    }
    private MyResource() {}
  }
}
