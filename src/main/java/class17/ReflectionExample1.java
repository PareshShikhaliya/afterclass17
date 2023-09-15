package class17;

import java.lang.reflect.*;
 class Person {
    private String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHello() {
        System.out.println("Hello, my name is " + name + " and I am " + age + " years old.");
    }
}

public class ReflectionExample1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        // 1. Find out/determine the class of an object.
        Person person = new Person("Alice", 30);
        Class<?> personClass = person.getClass();
        System.out.println("Class of person object: " + personClass.getName());

        // 2. Get information about class modifiers, fields, methods, constructors, and superclasses.
        var modifiers = personClass.getModifiers();
        System.out.println("Modifiers: " + Modifier.toString(modifiers));

        Field[] fields = personClass.getDeclaredFields();
        System.out.println("Fields:");
        for (Field field : fields) {
            System.out.println("- " + field.getName());
        }

        Method[] methods = personClass.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method method : methods) {
            System.out.println("- " + method.getName());
        }

        Constructor<?>[] constructors = personClass.getDeclaredConstructors();
        System.out.println("Constructors:");
        for (Constructor<?> constructor : constructors) {
            System.out.println("- " + constructor.getName());
        }

        Class<?> superClass = personClass.getSuperclass();
        System.out.println("Superclass: " + superClass.getName());

        // 3. Find out which methods belong to the implemented interface/interfaces.
        Class<?>[] interfaces = personClass.getInterfaces();
        System.out.println("Implemented Interfaces:");
        for (Class<?> iface : interfaces) {
            System.out.println("- " + iface.getName());
        }

        // 4. Create an instance of a class when the class name is not known until runtime.
        String className = "class17.Person";
        Class<?> dynamicClass = Class.forName(className);
        Person dynamicPerson = (Person) dynamicClass.getConstructor(String.class, int.class).newInstance("Bob", 25);
        dynamicPerson.sayHello();

        // 5. Get and set the value of an object field by name.
        Field ageField = personClass.getDeclaredField("age");
        ageField.setAccessible(true); // Enable access to the private field
        int currentValue = (int) ageField.get(person);
        System.out.println("Current age: " + currentValue);

        ageField.set(person, 35); // Set a new value for the age field
        System.out.println("Updated age: " + person.age);

        // 6. Call an object's method by name.
        Method sayHelloMethod = personClass.getDeclaredMethod("sayHello");
        sayHelloMethod.invoke(person);
    }
}
