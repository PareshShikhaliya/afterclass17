package class16;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

class EmployeeClass {
    private String firstName;
    private String lastName;
    private int employeeId;

    // Constructors, getters, and setters

    public EmployeeClass() {
    }

    public EmployeeClass(String firstName, String lastName, int employeeId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}

public class JsonSerializationDeserializationExample8 {
    public static void main(String[] args) {
        // Create an instance of ObjectMapper for JSON
        ObjectMapper jsonMapper = new ObjectMapper();

        // Serialize an EmployeeClass object to JSON
        try {
            EmployeeClass employee = new EmployeeClass("John", "Doe", 12345);
            jsonMapper.writeValue(new File("employee.json"), employee);
            System.out.println("EmployeeClass object serialized to 'employee.json'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize a JSON file to an EmployeeClass object
        try {
            EmployeeClass deserializedEmployee = jsonMapper.readValue(new File("employee.json"), EmployeeClass.class);
            System.out.println("Deserialized EmployeeClass from JSON:");
            System.out.println("First Name: " + deserializedEmployee.getFirstName());
            System.out.println("Last Name: " + deserializedEmployee.getLastName());
            System.out.println("EmployeeClass ID: " + deserializedEmployee.getEmployeeId());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
