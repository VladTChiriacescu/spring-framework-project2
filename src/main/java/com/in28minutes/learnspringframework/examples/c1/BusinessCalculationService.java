package com.in28minutes.learnspringframework.examples.c1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service
public class BusinessCalculationService {
    private DataService service;

    public BusinessCalculationService(DataService service) {
        this.service = service;
    }

    public int findMax() {
        return Arrays.stream(service.retrieveData()).max().orElse(0);
    }
}
