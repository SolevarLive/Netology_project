package ru.netology.Grishenko.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CashbackOperation extends Operation implements ConsolePrintable {
    private int cashbackAmount;

    public CashbackOperation(int id, int sum, String currency, String merchant) {
        super(id, sum, currency, merchant);
    }

    @Override
    public void printToConsole() {
        System.out.println("Cashback amount: " + cashbackAmount);
    }

}
