package com.wildan.Belajar.model;

import org.springframework.stereotype.Component;

/**
 * Created by DAN on 5/26/2019.
 */
@Component
public class SayHelloFilter {
    public String filter(String value){
        return value.toUpperCase();
    }
}
