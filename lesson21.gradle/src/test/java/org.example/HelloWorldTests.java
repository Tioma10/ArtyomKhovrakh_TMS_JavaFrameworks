package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HelloWorldTests {
    @Test
    void addition() {
        assertEquals("Hello World!", Main.getHelloWorld());
    }
}
