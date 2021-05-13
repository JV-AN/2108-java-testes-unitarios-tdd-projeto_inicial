package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ReajusteServiceTest {
    //Outras Anotações, @BeforeAll, @AfterAll, @AfterEach

    ReajusteService service;
    Funcionario funcionario;

    @BeforeEach
    public void inicializa(){
        service = new ReajusteService();
        funcionario = new Funcionario("Matheus", LocalDate.now(), new BigDecimal("1000"));
    }

    @Test
    public void reajusteDeveriaSerDeTresPorCentoParaFuncionariosComDesempenhoADesejar(){
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        Assertions.assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe15PorCentoParaFuncionariosComDesempenhoBom(){
        service.concederReajuste(funcionario, Desempenho.BOM);

        Assertions.assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDe20PorCentoParaFuncionariosComDesempenhoADesejar(){
        service.concederReajuste(funcionario, Desempenho.OTIMO);

        Assertions.assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }

}
