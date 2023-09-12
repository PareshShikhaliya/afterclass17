package class16;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;



public class DeserializationWithDifferentClass5 {
    public static void main(String[] args) {
        // Deserialize the OriginalPerson object using a ModifiedPerson class
        deserializeOriginalPersonWithModifiedClass();
    }

    private static void deserializeOriginalPersonWithModifiedClass() {
        try (FileInputStream fileIn = new FileInputStream("person.ser");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            // Attempt to deserialize the OriginalPerson object with a ModifiedPerson class
            OriginalPerson deserializedPerson = (OriginalPerson) objectIn.readObject();

            // This may lead to an InvalidClassException due to version mismatch
            System.out.println("Deserialized OriginalPerson with ModifiedPerson class:");
            System.out.println("Name: " + deserializedPerson.getName());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
