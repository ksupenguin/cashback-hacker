package ru.netology.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

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

    @Test
    public void checkThousandAmount() {
        Assertions.assertEquals(0, cashbackHackService.remain(1000));
    }

    @Test
    public void checkHalfAmount() {
        Assertions.assertEquals(500, cashbackHackService.remain(500));
    }

    @Test
    public void checkAlmostThousandAmount() {
        Assertions.assertEquals(999, cashbackHackService.remain(1));
    }
}
