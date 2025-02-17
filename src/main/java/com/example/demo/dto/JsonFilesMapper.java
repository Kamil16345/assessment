package com.example.demo.dto;

import com.example.demo.model.JsonData;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonFilesMapper {
    public static JsonData extractValueFromJson(File jsonFile) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(jsonFile, JsonData.class);
    }
}
