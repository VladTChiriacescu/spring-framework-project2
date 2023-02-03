package com.in28minutes.learnspringframework.examples.g1;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Named
class BusinessService {
    private DataService dataService;

    public DataService getDataService() {
        return dataService;
    }

    @Inject
    public void setDataService(DataService dataService) {
        System.out.println("Setter injection");
        this.dataService = dataService;
    }

    public String toString() {
        return "BusinessService class contains DataService instance: " + dataService;
    }
}

@Named
class DataService {

}
@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(CdiContextLauncherApplication.class)) {
            Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

            BusinessService service = context.getBean(BusinessService.class);
            System.out.println(service);
            System.out.println(service.getDataService());
        }
    }
}
