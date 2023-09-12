package class16;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

class Product {
    private String name;
    private double price;

    public Product() {
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

public class YamlSerializationDeserializationExample9 {
    public static void main(String[] args) {
        // Create an instance of ObjectMapper for YAML
        ObjectMapper yamlMapper = new ObjectMapper(new YAMLFactory());

        // Serialize a Product object to YAML
        try {
            Product product = new Product("Laptop", 999.99);
            yamlMapper.writeValue(new File("product.yaml"), product);
            System.out.println("Product object serialized to 'product.yaml'");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize a YAML file to a Product object
        try {
            Product deserializedProduct = yamlMapper.readValue(new File("product.yaml"), Product.class);
            System.out.println("Deserialized Product from YAML:");
            System.out.println("Name: " + deserializedProduct.getName());
            System.out.println("Price: " + deserializedProduct.getPrice());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
