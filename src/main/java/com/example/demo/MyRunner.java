package com.example.demo;

import com.example.demo.dto.JsonFilesMapper;
import com.example.demo.model.JsonData;
import com.example.demo.service.HtmlService.HtmlModifier;
import com.example.demo.service.JsonService.JsonFilesMaintainer;
import com.example.demo.service.ThymeleafService.TemplateGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Component
public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome in HTML genarator!");
        printMainMenu();
    }

    public static void printMainMenu() throws IOException {
        boolean endLoop = false;
        Scanner scanner = new Scanner(System.in);
        List<File> allExampleMetadataFiles = JsonFilesMaintainer.getAllExampleMetadataFiles();
        JsonFilesMapper.extractValueFromJson(allExampleMetadataFiles.get(0));

        System.out.println("Choose operation to execute: \n\t1. Create HTML \n\t2. Edit header of HTML \n\t3. Edit title of HTML \n\t4. Exit");
        while (!endLoop) {
            try {
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1 -> printHtmlTemplateMenu();
                    case 2 -> HtmlModifier.editHeader();
                    case 3 -> HtmlModifier.editeTitle();
                    case 4 -> endLoop = true;
                    default -> System.out.println("Incorrect type. Exiting to main menu...");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid type");
            }
        }
        scanner.close();
    }

    private static void printHtmlTemplateMenu() throws IOException {
        boolean endLoop = false;
        Scanner scanner = new Scanner(System.in);
        while (!endLoop) {
            System.out.println("Here is a list of available example-metadata.json files available under resources/static.");
            System.out.println("Choose one to create HTML template based on it.");
            System.out.println("------------------------------------------------");

            List<File> allExampleMetadataFiles = JsonFilesMaintainer.getAllExampleMetadataFiles();
            for (File file : allExampleMetadataFiles) {
                System.out.println(file.getParentFile().getName() + "/" + file.getName());
            }

            System.out.println("Choose json file to transform or type 'exit' to finish operation.");

            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("exit")) {
                endLoop = true;
                printMainMenu();
            } else {
                File file = JsonFilesMaintainer.getFile(input);
                JsonData jsonData = JsonFilesMapper.extractValueFromJson(file);
                TemplateGenerator templateGenerator = new TemplateGenerator();
                templateGenerator.generateTemplate(jsonData);
            }
        }
    }
}
