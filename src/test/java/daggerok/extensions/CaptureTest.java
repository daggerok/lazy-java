package daggerok.extensions;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@CaptureSystemOutput
class CaptureTest {

  @BeforeEach
  void beforeEach(CaptureSystemOutput.OutputCapture outputCapture) {
    assertFalse(outputCapture.toString().contains("@BeforeEach"));
    System.out.println("@BeforeEach");
    assertTrue(outputCapture.toString().contains("@BeforeEach"));
  }

  @AfterEach
  void afterEach(CaptureSystemOutput.OutputCapture outputCapture) {
    System.out.println("@AfterEach");
    outputCapture.expect(containsString("@BeforeEach"));
    outputCapture.expect(containsString("@AfterEach"));
  }

  @Test
  void systemOut(CaptureSystemOutput.OutputCapture outputCapture) {
    outputCapture.expect(containsString("SYS_OUT #1"));
    System.out.println("Printed to SYS_OUT #1");
    // The following would cause the test to fail after the
    // test method completes.
    // outputCapture.expect(containsString("Foo!"));
  }

  @Test
  void systemErr(CaptureSystemOutput.OutputCapture outputCapture) {
    outputCapture.expect(containsString("SYS_ERR #2"));
    System.err.println("Printed to SYS_ERR #2");
  }

  @Test
  void systemOutAndSystemErr(CaptureSystemOutput.OutputCapture outputCapture) {
    outputCapture.expect(containsString("SYS_OUT #3"));
    outputCapture.expect(containsString("SYS_ERR #3"));
    System.out.println("Printed to SYS_OUT #3");
    System.err.println("Printed to SYS_ERR #3");
  }
}
