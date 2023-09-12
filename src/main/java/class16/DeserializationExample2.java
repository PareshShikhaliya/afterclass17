package class16;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;


public class DeserializationExample2 {
    public static void main(String[] args) {
        // Deserialize the Student object from the file
        try (FileInputStream fileIn = new FileInputStream("student.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            // Read the serialized Student object from the file
            Student deserializedStudent = (Student) objectIn.readObject();

            // Now you have the deserialized Student object
            System.out.println("Deserialized Student:");
            System.out.println("Name: " + deserializedStudent.getName());
            System.out.println("Age: " + deserializedStudent.getAge());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
