package fa.training.services;

import fa.training.entities.Customer;
import fa.training.entities.Oder;
import fa.training.util.Validator;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImp implements  CustomerService, OderService{
    private Scanner scanner = new Scanner(System.in);
    private List<Customer> customerList = new ArrayList<>();

    @Override
    /**
     * Write list Customer to file data/customer.dat
     */
    public boolean save() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("data/customer.dat");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        objectOutputStream.writeObject(customerList);

        bufferedOutputStream.flush();
        objectOutputStream.flush();
        fileOutputStream.close();

        return true;
    }



    @Override
    /**
     * get list Customer from file data/customer.dat
     */
    public List<Customer> findAll() throws IOException, ClassNotFoundException {
        List<Customer> customers = new ArrayList<>();
        FileInputStream fileInputStream = new FileInputStream("data/customer.dat");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

        customers = (List<Customer>) objectInputStream.readObject();
        fileInputStream.close();
        return customers;
    }

    @Override
    public void display() {
        for (Customer c : customerList){
            System.out.println(c);
        }
    }

    @Override
    public List<Customer> search(String phone) {
        List<Customer> customers = new ArrayList<>();
        for (Customer c: customerList){
            if(c.getPhoneNumber().equals(phone)){
                customers.add(c);
            }
        }
        return customers;
    }

    @Override
    public boolean remove(String phone) {
        for (Customer c : customerList){
            if(c.getPhoneNumber().equals(phone)){
                customerList.remove(c);
            }
        }
        return true;
    }

    @Override
    /**
     * Create one customer oder
     */
    public void createCustomer() throws ParseException {
        System.out.print("Enter name:");
        String name = scanner.nextLine();
        System.out.print("Phone number (xxx-xxx-xxxx): ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Address: ");
        String address = scanner.nextLine();
        System.out.println("List oder_____");
        List<Oder> oderList = new ArrayList<>();
        String check = null;
        do {
            System.out.print("Number oder:");
            String number = scanner.nextLine();
            System.out.print("Date: ");
            LocalDate date = Validator.getInstance().validateDate();
            Oder oder =new Oder(number,date);
            oderList.add(oder);
            System.out.print("(If you want finish, enter N or n): ");
            check = scanner.nextLine();
        }while (!check.equals("N") && !check.equals("n"));
        Customer c = new Customer(name, phoneNumber,address, null);
        c.setOderList(oderList);
//        System.out.println(oderList);
//        System.out.println(c);
        customerList.add(c);
    }
}
