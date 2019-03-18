package org.moita.sb2.acceptance.base;

import org.moita.sb2.WebmodelApplication;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FixtureWirer {

    static final String[] EMPTY = new String[0];

    public static FixtureWirer INSTANCE = new FixtureWirer();

    private AutowireCapableBeanFactory beanFactory;

    private FixtureWirer() {
        ApplicationContext applicationContext = WebmodelApplication.run(EMPTY);
        beanFactory = applicationContext.getAutowireCapableBeanFactory();
    }

    public synchronized void wire(Fixture fixture) {
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