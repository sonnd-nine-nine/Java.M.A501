package fa.training.entities;

import fa.training.util.Validator;

import java.util.List;
import java.util.Scanner;

public class Customer{
    private String name;
    private String phoneNumber;
    private String address;
    private List<Oder> oderList;

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", oderList=" + oderList +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumbers) {
        while (!Validator.getInstance().validatePhoneNumber(phoneNumbers)){
            System.out.println("Form phone number xxx-xxx-xxxx");
            phoneNumbers = new Scanner(System.in).nextLine();
        }
        this.phoneNumber = phoneNumbers;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Oder> getOderList() {
        return oderList;
    }

    public void setOderList(List<Oder> oderList) {
        this.oderList = oderList;
    }

    public Customer(String name, String phoneNumber, String address, List<Oder> oderList) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.oderList = oderList;
    }

    public Customer() {
    }

}
