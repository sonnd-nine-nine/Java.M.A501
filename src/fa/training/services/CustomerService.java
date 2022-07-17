package fa.training.services;


import fa.training.entities.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {
    boolean save() throws IOException;
    List<Customer> findAll() throws IOException, ClassNotFoundException;
    void display();
    List<Customer> search(String phone);
    boolean remove(String phone);
}
