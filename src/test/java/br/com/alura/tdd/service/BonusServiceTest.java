package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BonusServiceTest {
    @Test
    void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
        Funcionario funcionario = new Funcionario("Ruan", LocalDate.now(), new BigDecimal("25000"));
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("0.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezPorCentoDoSalario() {
        Funcionario funcionario = new Funcionario("Ruan", LocalDate.now(), new BigDecimal("2500"));
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDeveriaSerDezProcentoParaSalarioIgualADezMil() {
        Funcionario funcionario = new Funcionario("Ruan", LocalDate.now(), new BigDecimal("10000"));
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(funcionario);

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}
