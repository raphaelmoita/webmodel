package org.moita.sb2.acceptance.base;

import org.moita.sb2.WebmodelApplication;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FixtureWirer {

    private static final String[] ARGS = {"fitness"};

    public static FixtureWirer INSTANCE = new FixtureWirer();

    private ApplicationContext applicationContext;

    private AutowireCapableBeanFactory beanFactory;

    public void wire(Fixture fixture) {

        if (applicationContext == null) {
            applicationContext = WebmodelApplication.run(ARGS);
            beanFactory = applicationContext.getAutowireCapableBeanFactory();
        }

        beanFactory.autowireBeanProperties(fixture, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
        beanFactory.autowireBean(fixture);
        beanFactory.initializeBean(fixture, fixture.getClass().getName());
    }

    public void wire_(Fixture fixture) {
        if (beanFactory == null) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(WebmodelApplication.class);
            beanFactory = context.getAutowireCapableBeanFactory();
        }
        beanFactory.autowireBeanProperties(fixture, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
        beanFactory.autowireBean(fixture);
        beanFactory.initializeBean(fixture, fixture.getClass().getName());
    }
}