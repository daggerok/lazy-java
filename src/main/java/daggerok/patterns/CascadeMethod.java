package daggerok.patterns;

import lombok.AllArgsConstructor;
import lombok.ToString;

import java.util.function.Consumer;

public class CascadeMethod {

  @ToString
  @AllArgsConstructor(staticName = "of")
  public static class Mailer {
    private String from, to, subject, body;

    public static void send(final Consumer<Mailer> consumer) {
      final Mailer mailer = new Mailer();
      consumer.accept(mailer);
      System.out.println(mailer);
    }

    public Mailer from(final String from) {
      this.from = from;
      return this;
    }

    public Mailer to(final String to) {
      this.to = to;
      return this;
    }

    public Mailer subject(final String subject) {
      this.subject = subject;
      return this;
    }

    public Mailer body(final String body) {
      this.body = body;
      return this;
    }

    private Mailer() {}
  }
}
