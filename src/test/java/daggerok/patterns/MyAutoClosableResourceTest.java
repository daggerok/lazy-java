package daggerok.patterns;

import daggerok.extensions.CaptureSystemOutput;
import daggerok.patterns.MyAutoClosableResource.MyResource;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;

@CaptureSystemOutput
class MyAutoClosableResourceTest {

  @Test
  void test(final CaptureSystemOutput.OutputCapture out) {

    MyResource.use(
        myResource -> myResource.add("hey! ")
                                .add("HO!")
                                .down());

    out.expect(containsString("ho"));
    out.expect(containsString("closed"));
  }
}
