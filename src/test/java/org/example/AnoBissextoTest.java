package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnoBissextoTest {

    @BeforeEach
    void setUp() {
        System.out.println("método beforeEach");
    }

    @Test
    void anoBissextoDeveSerMultiploDe4() {
        Assertions.assertTrue(AnoBissexto.checkLeapYear(2020));
        Assertions.assertTrue(AnoBissexto.checkLeapYear(1996));
    }

    @Test
    void anoBissextoDeveSerDivididoPor400() {
        boolean expectedResult = AnoBissexto.checkLeapYear(2020);
        Assertions.assertTrue(expectedResult);
    }

    @Test
    void anoImparNaoDeveserBissexto() {
        boolean expectedResult = AnoBissexto.checkLeapYear(3999);
        Assertions.assertFalse(expectedResult);
    }

    @AfterEach
    void tearDown() {
        System.out.println("método tearDown");

    }
}