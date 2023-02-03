package com.in28minutes.learnspringframework.examples.d1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
class ClassA {

}

@Component
@Lazy
class ClassB {
    private ClassA classA;

    public ClassB(ClassA classA) {
        //Logic
        this.classA = classA;
        System.out.println("Some initialization logic; classA: " + classA);
    }

    public void doSomething() {
        System.out.println("Do Something");
    }
}

@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(LazyInitializationLauncherApplication.class)) {
            System.out.println("Initialization of context is completed");

            String[] beanNames = context.getBeanDefinitionNames();

            Arrays.stream(beanNames).forEach(bean -> System.out.println("Bean: " + bean));

            context.getBean(ClassB.class).doSomething();
        }
    }
}
