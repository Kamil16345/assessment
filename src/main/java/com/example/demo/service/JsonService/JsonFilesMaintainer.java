package com.example.demo.service.JsonService;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JsonFilesMaintainer {
    private static File[] getAllFiles() {
        ClassLoader classLoader = JsonFilesMaintainer.class.getClassLoader();
        File folder = new File(classLoader.getResource("static/codedocusamples").getFile());
        return folder.listFiles();
    }

    public static List<File> getAllExampleMetadataFiles() {
        File[] allFiles = getAllFiles();
        List<File> result = new ArrayList<>();
        for (File file : allFiles) {
            File[] files = file.listFiles();
            for (File nestedFile : files) {
                if (nestedFile.getName().endsWith(".json")) {
                    result.add(nestedFile);
                }
            }
        }
        return result;
    }
}
