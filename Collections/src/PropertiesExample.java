import java.io.*;
import java.util.Properties;

public class PropertiesExample {

    public static void main(String[] args) {
        Properties properties = new Properties();

        properties.setProperty("color", "blue");
        properties.setProperty("width", "200");

        System.out.println("After setting properties:");
        listProperties(properties);

        properties.setProperty("color", "red");
        System.out.println("After replacing properties:");
        listProperties(properties);

        saveProperties(properties);
        System.out.println("After saving properties to properties.dat:");
        listProperties(properties);

        properties.clear();
        System.out.println("After clearing properties:");
        listProperties(properties);

        loadProperties(properties);
        System.out.println("After loading properties from properties.dat:");
        listProperties(properties);

        Object value = properties.getProperty("color");
        if (value != null) {
            System.out.println("The property for color is set to: " + value.toString());
        } else {
            System.out.println("There is no color property in the table!");
        }
    }

    private static void listProperties(Properties properties) {
        properties.entrySet().stream().forEach(e -> System.out.println(e.getKey() + ": " + e.getValue()));
    }

    private static void saveProperties(Properties properties) {
        FileOutputStream output = null;

        try {
            output = new FileOutputStream("properties.dat");
            properties.store(output, "Sample Properties");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void loadProperties(Properties properties) {
        FileInputStream input = null;

        try {
            input = new FileInputStream("properties.dat");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
