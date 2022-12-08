package demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        testee.deposit(100);
        testee.deposit(200);

        double actual = testee.getBalance();
        assertEquals( 300, actual);
    }

    @Test
    void when_deposit_100_and_withdraw_50_then_the_result_is_50() {
        testee.deposit(100);
        testee.withdraw(50);

        double actual = testee.getBalance();
        assertEquals( 50, actual);
    }

    @Test
    void when_withdraw_a_negative_amount_then_an_IllegalArgumentException_is_thrown() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            testee.withdraw(-1);
        });
    }
}