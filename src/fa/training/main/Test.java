package fa.training.main;

import fa.training.entities.Customer;
import fa.training.services.CustomerService;
import fa.training.services.CustomerServiceImp;
import fa.training.services.OderService;

import java.awt.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private static CustomerService customerService = new CustomerServiceImp();
    private static OderService oderService = new CustomerServiceImp();
    public static void main(String[] args) throws ParseException {
        int choose;
        do {
            choose = Menu();
            switch (choose){
                case 1:
                    menuCreateCustomer();
                    break;
                case 2:
                    menuDisplayCustomer();
                    break;
                case 3:
                    menuSearchCustomer();
                    break;
                case 4:
                    menuSearchCustomerRemove();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Choose a func...");
                    break;
            }
        }while (choose!=5);
    }

    public static int Menu(){
        System.out.println("Choose func:\n" +
                "1. Add new customer.\n" +
                "2. Show all customer\n" +
                "3. Search customer.\n" +
                "4. Remove customer\n" +
                "5. Exit.");
        return Integer.parseInt(new Scanner(System.in).nextLine());
    }

    public static void menuCreateCustomer() throws ParseException {
        System.out.println("Create one customer:");
        oderService.createCustomer();
    }

    public static void menuDisplayCustomer(){
        System.out.println("------List of Customer_______");
        customerService.display();
    }

    public static void menuSearchCustomer(){
        System.out.println("Search customer_____");
        System.out.print("Enter phoneNumber Customer:  ");
        String phoneNumber = new Scanner(System.in).nextLine();
        customerService.search(phoneNumber);
    }public static void menuSearchCustomerRemove(){
//        System.out.println("Search customer_____");
        System.out.print("Enter phoneNumber Customer to remove:  ");
        String phoneNumber = new Scanner(System.in).nextLine();
        customerService.remove(phoneNumber);
    }
}
