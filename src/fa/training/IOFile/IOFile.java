package fa.training.IOFile;

import fa.training.entities.Customer;

import java.io.*;
import java.util.List;

public class IOFile {
    public static void readFromFile() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("customer.dat");
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);

        List<Customer> customerList = (List<Customer>) objectInputStream.readObject();
        fileInputStream.close();
    }

    public static String writeToFile(List<String> customer) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("customer.dat");
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(bufferedOutputStream);

        objectOutputStream.writeObject(customer);
        bufferedOutputStream.flush();
        objectOutputStream.flush();
        fileOutputStream.flush();
        return "Write Done";
    }
}
