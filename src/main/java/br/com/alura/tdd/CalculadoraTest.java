package br.com.alura.tdd;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraTest {

    @Test
    public void deveriaSomarDoisNumeros(){
        Calculadora calc = new Calculadora();
        int soma = calc.somar(2,9);

        Assert.assertEquals(11, soma);

    }
}
