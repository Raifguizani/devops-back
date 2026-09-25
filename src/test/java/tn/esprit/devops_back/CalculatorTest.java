package tn.esprit.devops_back;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {
    @Test
    void addTwoNumbers() {
        assertEquals(6, new Calculator().add(2, 3));
    }
}
