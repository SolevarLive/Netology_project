package ru.netology.Grishenko.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Operation {

    private int id;
    private int sum;
    private String currency;
    private String merchant;

    public Operation(int id, int sum, String currency, String merchant){
        this.id=id;
        this.sum =sum;
        this.currency =currency;
        this.merchant =merchant;
    }

    @Override
    public String toString(){
        return "Operation{" +
                "id" + id +
                ", sum=" + sum +
                ", currency='" + currency +'\'' +
                ", merchanty='" + merchant   +'\'' +
                '}';

    }
    public void printToConsole() {
        System.out.println("Operation ID: " + id);
        System.out.println("Sum: " + sum);
        System.out.println("Currency: " + currency);
        System.out.println("Merchant: " + merchant);
    }
}


