package com.example.vkrestapi.models;

import lombok.Data;

@Data
public class Todo {
    private Integer userId;
    private Integer id;
    private String title;
    private String body;
}
