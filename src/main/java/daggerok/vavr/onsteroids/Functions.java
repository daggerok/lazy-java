package daggerok.vavr.onsteroids;

import io.vavr.Function7;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Functions {

  private Functions() {}

  public static final Function7<String, String, String, String, String, String, String, String> functions7 =
      (one, two, three, four, five, six, seven) ->
          one + two + three + four + five + six + seven;
}
