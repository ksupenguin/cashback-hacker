package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CashbackHackServiceTest {

    private final CashbackHackService cashbackHackService = new CashbackHackService();

    @Test
    public void checkNegativeAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cashbackHackService.remain(-1));
    }

    @Test
    public void checkZeroAmount() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> cashbackHackService.remain(0));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/params.csv", numLinesToSkip = 1)
    public void checkAmount(int expected, int amount) {
        Assertions.assertEquals(expected, cashbackHackService.remain(amount));
    }
}
