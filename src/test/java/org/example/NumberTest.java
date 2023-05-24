package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NumberTest {

    @ParameterizedTest
    @ValueSource (ints = {1 , 5 , Integer.MAX_VALUE})
    void deveVerificarSeONumeroEhImpar(int number) {
        assertTrue(Number.isOdd(number));
    }

}