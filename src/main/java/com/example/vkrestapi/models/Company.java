package com.example.vkrestapi.models;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Company {
    private String name;
    private String catchPhrase;
    private String bs;
}
