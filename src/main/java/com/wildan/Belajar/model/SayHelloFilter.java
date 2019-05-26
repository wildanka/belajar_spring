package com.wildan.Belajar.model;

import org.springframework.stereotype.Component;

@Component
public class SayHelloFilter {
    public String filter(String value){
        return value.toUpperCase();
    }
}
