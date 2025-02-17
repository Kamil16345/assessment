package com.example.demo.service.JsonService;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JsonFilesMaintainer {
    private static File[] getAllFiles() {
        ClassLoader classLoader = JsonFilesMaintainer.class.getClassLoader();
        File folder = new File(classLoader.getResource("static/codedocusamples").getFile());
        return folder.listFiles();
    }

    public static List<File> getAllExampleMetadataFiles() {
        return Arrays.stream(getAllFiles())
                .flatMap(file -> Arrays.stream(file.listFiles()))
                .filter(file -> file.getName().endsWith(".json"))
                .collect(Collectors.toList());
    }

    public static File getFile(String filePath) {
        ClassLoader classLoader = JsonFilesMaintainer.class.getClassLoader();
        File jsonFile = new File(classLoader.getResource("static/codedocusamples/" + filePath).getFile());
        return jsonFile;
    }
}
