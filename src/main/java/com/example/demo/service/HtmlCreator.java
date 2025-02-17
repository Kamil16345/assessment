package com.example.demo.service;

import lombok.Data;

@Data
public class HtmlCreator {

    public static String createHtmlTemplate(){
        System.out.println("Successfully created HTML file.");
        return "Successfully created HTML file.";
    }
}
