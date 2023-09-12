package class16;

import java.io.*;

class Employee implements Serializable {
    private String name;
    private transient double salary; // Mark salary field as transient

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }
}

public class TransientExample3 {
    public static void main(String[] args) {
        // Create an Employee object
        Employee employee = new Employee("Alice", 50000.0);

        // Serialize the Employee object to a file
        try (FileOutputStream fileOut = new FileOutputStream("employee.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(employee);
            System.out.println("Employee object serialized and saved to 'employee.ser'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the Employee object from the file
        try (FileInputStream fileIn = new FileInputStream("employee.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            // Read the serialized Employee object from the file
            Employee deserializedEmployee = (Employee) objectIn.readObject();

            // Print employee details after deserialization
            System.out.println("Deserialized Employee:");
            System.out.println("Name: " + deserializedEmployee.getName());

            // Since 'salary' is transient, it won't be present in the deserialized object
            System.out.println("Salary: " + deserializedEmployee.getSalary());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
