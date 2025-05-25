package _Other.FileIO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Java program for file I/O and serialization: reading and writing objects to a file.
 */
public class SerializeObjects {
    /**
     * Serializes a list of objects and writes them to a file.
     *
     * @param fileName   The name of the file to write to.
     * @param objectList The list of objects to serialize and write.
     * @throws IOException If an I/O error occurs during serialization or file writing.
     */
    public static void serializeObjects(String fileName, List<Object> objectList) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(objectList);
        }
    }

    /**
     * Deserializes objects from a file.
     *
     * @param fileName The name of the file to read from.
     * @return The list of deserialized objects.
     * @throws IOException            If an I/O error occurs during deserialization or file reading.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    public static List<Object> deserializeObjects(String fileName) throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<Object>) inputStream.readObject();
        }
    }

    public static void main(String[] args) {
        String fileName = "serialized_objects.dat";

        // Creating a list of objects to serialize
        List<Object> objectList = new ArrayList<>();
        objectList.add("Hello, World!");
        objectList.add(42);
        objectList.add(3.14);

        try {
            // Serialize and write objects to a file
            serializeObjects(fileName, objectList);

            // Deserialize objects from the file
            List<Object> deserializedList = deserializeObjects(fileName);

            // Display the deserialized objects
            System.out.println("Deserialized Objects:");
            for (Object obj : deserializedList) {
                System.out.println(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
