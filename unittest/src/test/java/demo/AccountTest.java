package demo;

import org.junit.jupiter.api.*;

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
    @Disabled
    void when_deposit_zero_dot_one_and_zero_dot_two_then_result_is_zero_dot_three() {
        testee.deposit(0.1);
        testee.deposit(0.2);
        double actual = testee.getBalance();
        assertEquals(0.3, actual);
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