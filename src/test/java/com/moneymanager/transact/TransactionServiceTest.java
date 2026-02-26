package com.moneymanager.transact;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

public class TransactionServiceTest {
    //Checking working of addTransaction method
    @Test
    public void testAddTransaction() {
        TransactionService service = new TransactionService();
        Transaction transaction = service.addTransaction("Expense", 100.0, 
        LocalDate.now());
        assert transaction.getId() == 1;
        assert transaction.getType().equals("Expense");
        assert transaction.getAmount() == 100.0;
    }

    //Add Negative Amount
    @Test
    void shouldThrowExceptionForNegativeAmount() {
        TransactionService service = new TransactionService();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.addTransaction(
                    "Expense",
                    -1000,
                    LocalDate.now()
            );
        });

        assertEquals("Amount must be greater than 0", exception.getMessage());
    }
}
