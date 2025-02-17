package com.example.demo.service.ThymeleafService;

import com.example.demo.model.JsonData;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class TemplateGenerator {

    private final TemplateEngine templateEngine;
    private static final String OUTPUT_DIR = "C:\\thymeleaf-output";

    public TemplateGenerator() {
        ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
        resolver.setPrefix("templates/");
        resolver.setSuffix(".html");
        templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(resolver);
    }

    public void generateTemplate(JsonData jsonFileData) throws IOException {

        Context context = new Context();
        context.setVariable("title", jsonFileData.getTitle());
        context.setVariable("intro", jsonFileData.getIntro());
        context.setVariable("description", jsonFileData.getDescription());
        context.setVariable("method", jsonFileData.getMethod());
        context.setVariable("url", jsonFileData.getUrl());
        context.setVariable("tags", jsonFileData.getTags());

        checkIfOutputDirExists();
        Writer writer = new FileWriter(OUTPUT_DIR + "\\hello-thymeleaf" + System.currentTimeMillis() + ".html");
        writer.write(templateEngine.process("template.html", context));
        writer.close();
    }

    public void checkIfOutputDirExists() {
        File directory = new File(OUTPUT_DIR);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }
}