package com.practise.lld.service;

import jakarta.inject.Inject;
import jakarta.inject.Singleton;

@Singleton
public class HelloWorldService {

    public String getMessage() {
        return "helloWorld";
    }
}
