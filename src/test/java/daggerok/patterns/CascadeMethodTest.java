package daggerok.patterns;

import daggerok.extensions.CaptureSystemOutput;
import daggerok.extensions.CaptureSystemOutput.OutputCapture;
import daggerok.patterns.CascadeMethod.Mailer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;

@CaptureSystemOutput
class CascadeMethodTest {

  @Test @DisplayName("testing cascade methods")
  void testMailer(final OutputCapture out) {

    Mailer.send(
        mailer -> mailer.from("build CI")
                        .to("me")
                        .subject("your code is suck...")
                        .body("and you should kill yourself..."));

    out.expect(containsString("your code is suck"));
  }
}
