package class16;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class OriginalPerson implements Serializable {
    private String name;
   // private int age;

    public OriginalPerson(String name, int age) {
        this.name = name;
       // this.age = age;
    }

    public String getName() {
        return name;
    }

//    public int getAge() {
//        return age;
//    }
}

public class SerializationWithDifferentClass4 {
    public static void main(String[] args) {
        // Serialize an OriginalPerson object to a file
        serializeOriginalPerson();
    }

    private static void serializeOriginalPerson() {
        try (FileOutputStream fileOut = new FileOutputStream("person.ser");
             ObjectOutputStream objectOut = new ObjectOutputStream(fileOut)) {
            OriginalPerson person = new OriginalPerson("Alice", 25);
            objectOut.writeObject(person);
            System.out.println("OriginalPerson object serialized and saved to 'person.ser'");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
