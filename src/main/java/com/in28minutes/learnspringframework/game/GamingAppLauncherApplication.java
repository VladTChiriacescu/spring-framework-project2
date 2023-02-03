package com.in28minutes.learnspringframework.game;

import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("com.in28minutes.learnspringframework.game")
public class GamingAppLauncherApplication {

    public static void main(String[] args) {
        try(var context = new AnnotationConfigApplicationContext(GamingAppLauncherApplication.class)) {
            context.getBean(GameRunner.class).run();
//            System.out.println(context.getBean("game"));
//            System.out.println(context.getBean("game2"));
//            context.getBean(GamingConsole.class).up();
//
//            context.getBean(GameRunner.class).run();
//
//            GameRunner gameRunner2 = (GameRunner)context.getBean("gameRunner2");
//            gameRunner2.run();
        }
    }
}
