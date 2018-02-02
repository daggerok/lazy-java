package daggerok.vavr.plain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Functions {

  private Functions() {}

  public static String functions7(final String one,
                                  final String two,
                                  final String three,
                                  final String four,
                                  final String five,
                                  final String six,
                                  final String seven) {

    log.info("1: {}", one);
    log.info("2: {}", two);
    log.info("3: {}", three);
    log.info("4: {}", four);
    log.info("5: {}", five);
    log.info("6: {}", six);
    log.info("7: {}", seven);

    return one + two + three + four + five + six + seven;
  }
}
