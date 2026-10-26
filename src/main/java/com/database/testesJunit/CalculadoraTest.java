package com.database.testesJunit;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculadoraTest {

    @Test
    void testeSoma() {

        Calculadora calculadora = new Calculadora();

        int resultado = calculadora.somar(2, 3);

        assertEquals(5, resultado);
    }
}
