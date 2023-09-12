package class16;

import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

class Person {
    private String fullName;
    private int age;
    private Date birthDate;
    private boolean isStudent;

    public Person() {
    }

    public Person(String fullName, int age, Date birthDate, boolean isStudent) {
        this.fullName = fullName;
        this.age = age;
        this.birthDate = birthDate;
        this.isStudent = isStudent;
    }

    @JsonProperty("full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @JsonIgnore
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @JsonFormat(pattern = "dd-MM-yyyy")
    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @JsonProperty("is_student")
    public boolean isStudent() {
        return isStudent;
    }

    public void setStudent(boolean student) {
        isStudent = student;
    }
}

public class JacksonAnnotationExample10 {
    public static void main(String[] args) throws IOException {
        // Configure ObjectMapper to be case-insensitive
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date birthDate = null;
        try {
            birthDate = dateFormat.parse("20-05-1990");
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }

        Person person = new Person("John Doe", 30, birthDate, true);

        // Serialize to JSON
        String json = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(person);

        System.out.println("Serialized JSON:");
        System.out.println(json);

        // Deserialize from JSON
        Person deserializedPerson = mapper.readValue(json, Person.class);

        System.out.println("Deserialized Person:");
        System.out.println("Full Name: " + deserializedPerson.getFullName());
        System.out.println("Age: " + deserializedPerson.getAge());
        System.out.println("Birth Date: " + dateFormat.format(deserializedPerson.getBirthDate()));
        System.out.println("Is Student: " + deserializedPerson.isStudent());
    }
}
