package class16;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

class Book {
    private String title;
    private String author;
    private int publicationYear;

    // Constructors, getters, and setters

    public Book() {
    }

    public Book(String title, String author, int publicationYear) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
}

public class XmlSerializationDeserializationExample7 {
    public static void main(String[] args) {
        // Create an instance of ObjectMapper for XML
        XmlMapper xmlMapper = new XmlMapper();

        // Serialize a Book object to XML
        try {
            Book book = new Book("The Catcher in the Rye", "J.D. Salinger", 1951);
            xmlMapper.writeValue(new File("book.xml"), book);
            System.out.println("Book object serialized to 'book.xml'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize an XML file to a Book object
        try {
            Book deserializedBook = xmlMapper.readValue(new File("book.xml"), Book.class);
            System.out.println("Deserialized Book from XML:");
            System.out.println("Title: " + deserializedBook.getTitle());
            System.out.println("Author: " + deserializedBook.getAuthor());
            System.out.println("Publication Year: " + deserializedBook.getPublicationYear());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
