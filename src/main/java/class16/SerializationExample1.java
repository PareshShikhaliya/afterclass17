package class16;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

// A simple class that implements the Serializable interface
class Student implements Serializable {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class SerializationExample1 {
    public static void main(String[] args) {
        // Create a Student object
        Student student = new Student("Alice", 20);

        // Serialize the Student object to a file
        try (FileOutputStream fileOut = new FileOutputStream("student.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            objectOut.writeObject(student);
            System.out.println("Student object serialized and saved to 'student.ser'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
