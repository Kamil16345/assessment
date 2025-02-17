package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class JsonData {
    @JsonProperty("enableTry")
    private boolean enableTry;
    @JsonProperty("title")
    private String title;
    @JsonProperty("intro")
    private String intro;
    @JsonProperty("description")
    private String description;
    @JsonProperty("method")
    private String method;
    @JsonProperty("url")
    private String url;
    @JsonProperty("tags")
    private List<String> tags;

    public JsonData() {
    }
}
