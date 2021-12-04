package app;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    private final List<String> words = new ArrayList<>();

    public void readFileToList(File file) {
        if (file == null) {
            return;
        }
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public File getFileFromResource(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found!");
        } else {
            return new File(resource.getFile());
        }
    }

    public List<String> getList() {
        return words;
    }
}
