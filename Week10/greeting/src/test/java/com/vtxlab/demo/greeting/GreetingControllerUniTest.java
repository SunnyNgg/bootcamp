package com.vtxlab.demo.greeting;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.vtxlab.demo.greeting.controller.GreetingOperation;
import com.vtxlab.demo.greeting.controller.impl.GreetingController;
import com.vtxlab.demo.greeting.service.GreetingService;

// Junit 5 
// only call method
@ExtendWith(SpringExtension.class) // @Mock, @InjectMocks
public class GreetingControllerUniTest {

  @Mock
  // Mock the dependency of greetingOperation
  GreetingService greetingService;
  
  private GreetingOperation greetingOperation;

  @BeforeEach
  void setup(){
    greetingOperation = new GreetingController(greetingService);
  }


  private void testHelloworld(String input, String output, String notEqualOutput){
    // Mock ITO
    // Given 
    Mockito.when(greetingService.greeting()).thenReturn(input);
    // When 
    String string = greetingOperation.greeting();
    // Then 
    if (output != null){
    Assertions.assertThat(string).isEqualTo(output);
  }
   if (notEqualOutput != null){
    Assertions.assertThat(string).isNotEqualTo(notEqualOutput);
   }
}
    @Test
    void testCases(){
      // Test Equal
      testHelloworld("Hello world", "Hello worldd", "hello");
      testHelloworld("", "d", "c");
      testHelloworld("abc", "abcd", "bcda");

      // Test Not Equal 
    }
 


}
