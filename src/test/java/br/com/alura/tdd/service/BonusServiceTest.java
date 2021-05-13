package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void bonusDeveriaSerZero() {
        BonusService bonusService = new BonusService();
//       assertThrows(IllegalArgumentException.class,
//               () ->   bonusService.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("15000")))
//);
       try{
           bonusService.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("15000")));
           fail();
       } catch (Exception ignored){
       }
    }

    @Test
    void bonusDeveriaSerDezPorcentoDoSalario() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("1500")));

        assertEquals(new BigDecimal("150.0"), bonus);
    }

    @Test
    void bonusDeveriaSerExatamenteMil() {
        BonusService bonusService = new BonusService();
        BigDecimal bonus = bonusService.calcularBonus(new Funcionario("João", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.0"), bonus);
    }
}