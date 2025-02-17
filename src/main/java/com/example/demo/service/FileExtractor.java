package com.example.demo.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileExtractor {
    public static File[] getAllFiles() {
        ClassLoader classLoader = FileExtractor.class.getClassLoader();
        File folder = new File(classLoader.getResource("static/codedocusamples").getFile());
        File[] files = folder.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
        return files;
    }

    public static List<File> getAllExampleMetadataFiles() {
        File[] allFiles = getAllFiles();
        List<File> result = new ArrayList<>();
        for (File file : allFiles) {
            File[] files = file.listFiles();
            for (File nestedFile : files){
                if(nestedFile.getName().endsWith(".json")){
                    result.add(nestedFile);
                }
            }
        }
        return result;
    }
}
