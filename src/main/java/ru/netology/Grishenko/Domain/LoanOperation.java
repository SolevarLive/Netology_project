package ru.netology.Grishenko.Domain;

import lombok.Data;

@Data
public class LoanOperation extends Operation {
    private int loanId;

    public LoanOperation(int id, int sum, String currency, String merchant) {
        super(id, sum, currency, merchant);
    }

    @Override
    public void printToConsole() {
        System.out.println("Loan operation: " + loanId);
    }
}
