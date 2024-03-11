package com.example.vkrestapi.models;

import lombok.Data;

@Data
public class Photo {
    private Integer albumId;
    private Integer id;
    private String title;
    private String url;
    private String thumbnailUrl;
}
