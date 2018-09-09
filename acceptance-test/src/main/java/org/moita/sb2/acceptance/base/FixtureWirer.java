package org.moita.sb2.acceptance.base;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class FixtureWirer {

    private static AutowireCapableBeanFactory beanFactory;
    private static String[] ARGS = {};
    
    static {
        ConfigurableApplicationContext context = SpringApplication.run(FixtureWirer.class, ARGS);
        beanFactory = new ClassPathXmlApplicationContext(context).getAutowireCapableBeanFactory();
    }
    
    public static void wire(Fixture fixture) {
        beanFactory.autowireBeanProperties(fixture, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
        beanFactory.autowireBean(fixture);
        beanFactory.initializeBean(fixture, fixture.getClass().getName());
    }
}