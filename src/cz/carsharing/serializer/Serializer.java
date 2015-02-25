package cz.carsharing.serializer;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nell on 25.2.2015.
 */
public class Serializer<T extends GetID, PK extends Serializable> {

    private static final String locationDatabase = "C:\\WORK\\database\\";
    private String location;
    private String objectPath;

    public Serializer(String path) {
        this.objectPath = path;
    }

    public T find(PK id) throws IOException, ClassNotFoundException {
        return returnFile(locationDatabase + objectPath + "\\" + id);
    }

    public List<T> findAll() throws IOException {
        List<T> list = new ArrayList<T>();
        Files.walk(Paths.get(locationDatabase + objectPath)).forEach(
                filePath -> {
                    if (Files.isRegularFile(filePath)) {
                        try {
                            list.add(returnFile(filePath.toString()));
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (ClassNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }

        );
        return list;
    }

    public PK create(T object) throws IOException {
        location = locationDatabase + objectPath + "\\" + object.getId();
        FileOutputStream fos = new FileOutputStream(location);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(object);
        oos.close();
        return null;
    }

    public void update(T object) {

    }

    public void delete(T object) {

    }

    private T returnFile(String path) throws IOException, ClassNotFoundException {
        FileInputStream fis = null;
        fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        T object = (T) ois.readObject();
        ois.close();
        return object;

    }
}
