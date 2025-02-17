package com.example.demo.repository;

import javax.swing.text.html.HTML;
import java.util.List;
import java.util.Optional;

public interface HtmlRepository {
    void create(HTML html);

    Optional<HTML> findById(String id);

    List<HTML> getAll();

    void update(HTML item);

    void remove(HTML item);
}
