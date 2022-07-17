package fa.training.entities;

import fa.training.util.Validator;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Scanner;

public class Oder {
    protected String number;
    protected LocalDate date;

    @Override
    public String toString() {
        return "Oder{" +
                "number='" + number + '\'' +
                ", date=" + date +
                '}';
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String oderNumber) {
        while (!Validator.getInstance().validateOderNumber(oderNumber)){
            System.out.println("Oder number have length = 10");
            oderNumber = new Scanner(System.in).nextLine();
        }
        this.number = oderNumber;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate dates) throws ParseException {
        this.date = dates;
    }

    public Oder(String number, LocalDate date) {
        this.number = number;
        this.date = date;
    }

    public Oder() {
    }
}
