package fa.training.util;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator {
    private static Validator instance;
    public static Validator getInstance(){
        if(instance==null){
            instance = new Validator();
        }
        return instance;
    }

    public boolean validatePhoneNumber(String phoneNumber){
        String regex = "^(\\d{3}[- ]?){2}\\d{4}$";
        if(phoneNumber.matches(regex)){
            return true;
        }
        return false;
    }

    public boolean validateOderNumber(String oderNumber){
        String regex = "\\d{10}$";
        if(oderNumber.matches(regex)){
            return true;
        }
        return false;
    }

    public LocalDate validateDate() throws ParseException {
        System.out.println("Enter date format dd/mm/yyyy");
        LocalDate date = null;
        String inputDate = new Scanner(System.in).nextLine();
        try {
            DateTimeFormatter dt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            date = LocalDate.parse(inputDate, dt);
            System.out.println(date);
            return date;
        }catch (DateTimeParseException e){
        }
        return validateDate();
    }
}
