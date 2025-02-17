package com.example.demo;

import com.example.demo.service.FileExtractor;
import com.example.demo.service.HtmlCreator;
import com.example.demo.service.HtmlModifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter word!");
        boolean endLoop = false;
        Scanner scanner = new Scanner(System.in);
        FileExtractor.getAllExampleMetadataFiles();

        System.out.println("Welcome in HTML genarator! \n Choose operation to execute: \n\t1. Create HTML \n\t2. Edit header of HTML \n\t3. Edit title of HTML \n\t4. Exit");
        while (!endLoop) {
            try {
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1 -> HtmlCreator.createHtmlTemplate();
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
}
