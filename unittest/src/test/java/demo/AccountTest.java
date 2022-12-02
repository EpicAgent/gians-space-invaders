package demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class AccountTest {

    private Account testee;

    @BeforeEach
    void setUp() {
        // Diese Methode wird vor jedem Test ausgeführt.
        testee = new Account();
    }

    @AfterEach
    void tearDown() {
        // Dient zum Aufräumen nach jedem UnitTest.
    }

    @Test
    void when_deposit_100_and_200_then_the_result_is_300() {
        testee.deposit(BigDecimal.valueOf(100));
        testee.deposit(BigDecimal.valueOf(200));

        BigDecimal actual = testee.getBalance();
        assertEquals( true, actual.compareTo(BigDecimal.valueOf(300)) == 0);
    }

    @Test
    void when_deposit_100_and_withdraw_50_then_the_result_is_50() {
        testee.deposit(BigDecimal.valueOf(100));
        testee.withdraw(BigDecimal.valueOf(50));

        BigDecimal actual = testee.getBalance();
        assertEquals( true, actual.compareTo(BigDecimal.valueOf(50)) == 0);
    }

    @Test
    void when_withdraw_a_negative_amount_then_an_IllegalArgumentException_is_thrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testee.withdraw(BigDecimal.valueOf(-1));
        });
    }
}