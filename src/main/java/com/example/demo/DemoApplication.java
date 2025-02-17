package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
        System.out.println("Hello world!");

        boolean endLoop = false;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome in HTML genarator! \n Choose operation to execute: \n\t1. Create HTML \n\t2. Edit header of HTML \n\t3. Edit title of HTML \n\t4. Exit");
        while (!endLoop) {
            try {
                int choose = scanner.nextInt();
                switch (choose) {
                    case 1 -> createHtmlBasedOnJsonFile();
                    case 2 -> editHeader();
                    case 3 -> editeTitle();
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
