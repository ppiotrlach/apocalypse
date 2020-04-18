import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HelloWorldTest {

    @Test
    public void shouldReturnHelloWorld(){
        assertEquals(HelloWorld.helloWorld(),"Hello World");
    }
}
