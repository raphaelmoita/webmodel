package org.moita.sb2.acceptance.base;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Configuration
@ComponentScan(basePackages = "org.moita.sb2")
public class FixtureWirer {

    public static FixtureWirer INSTANCE = new FixtureWirer();

    private AutowireCapableBeanFactory beanFactory;

    public void wire(Fixture fixture) {
        if (beanFactory == null) {
            ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(FixtureWirer.class);
            beanFactory = context.getAutowireCapableBeanFactory();
        }
        beanFactory.autowireBeanProperties(fixture, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
        beanFactory.autowireBean(fixture);
        beanFactory.initializeBean(fixture, fixture.getClass().getName());
    }
}