import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DemoTest {

    @Test
    void shouldSayHelloWorld() {
        var demo = new Demo();
        demo.sayHello();
    }
}
