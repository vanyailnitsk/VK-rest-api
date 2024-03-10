package com.example.vkrestapi.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Geo {
    private String lat;
    private String lng;
}
