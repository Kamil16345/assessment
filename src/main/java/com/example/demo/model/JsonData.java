package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JsonData {
    @JsonProperty("enableTry")
    private boolean enableTry;
    @JsonProperty("title")
    private String title;
    @JsonProperty("intro")
    private String intro;
    @JsonProperty("description")
    private String description;
    @JsonProperty("url")
    private String url;
    @JsonProperty("tags")
    private List<String> tags;

    public JsonData() {
    }
}
