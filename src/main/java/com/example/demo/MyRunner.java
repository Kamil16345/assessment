package com.example.demo;

import org.springframework.boot.CommandLineRunner;

import java.util.Scanner;

public class MyRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Enter word!");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println(line);
    }
}
