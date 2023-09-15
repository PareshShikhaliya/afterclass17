package class17;

import java.lang.reflect.*;

class Student {
    private String name;
    private int age;

    public Student() {
        this.name = "Unknown";
        this.age = 0;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void introduce() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}

public class ReflectionExample2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException, NoSuchFieldException {
        // 1. Get the class object for Student.
        Class<?> studentClass = Class.forName("class17.Student");

        // 2. Create an array of Student objects dynamically.
        Student[] students = (Student[]) Array.newInstance(studentClass, 3);

        // 3. Create instances of Student and populate the array.
        for (int i = 0; i < students.length; i++) {
            students[i] = (Student) studentClass.getConstructor(String.class, int.class)
                    .newInstance("Student" + (i + 1), 20 + i);
        }

        // 4. Access and modify array elements.
        students[0].introduce();
        Field nameField = studentClass.getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(students[0], "Paresh");
        students[0].introduce();

        // 5. Get the length of the array.
        int arrayLength = Array.getLength(students);
        System.out.println("Array Length: " + arrayLength);

        // 6. Iterate through the array elements.
        for (int i = 0; i < arrayLength; i++) {
            Student student = (Student) Array.get(students, i);
            student.introduce();
        }
    }
}
