package org.moita.sb2.acceptance.base;

import org.moita.sb2.WebmodelApplication;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.moita.sb2")
public class FixtureWirer {

    public static FixtureWirer INSTANCE = new FixtureWirer();

    private AutowireCapableBeanFactory beanFactory;

    public void wire(Fixture fixture) { //FIXME: ClassNotFoundException ??? Why ???
        ApplicationContext applicationContext = new WebmodelApplication().run(new String[]{"123"});

        if (beanFactory == null) {
            beanFactory = applicationContext.getAutowireCapableBeanFactory();
        }
        beanFactory.autowireBeanProperties(fixture, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
        beanFactory.autowireBean(fixture);
        beanFactory.initializeBean(fixture, fixture.getClass().getName());
    }

    public void wire_(Fixture fixture) {
        if (beanFactory == null) {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(FixtureWirer.class);
            context.getEnvironment().setActiveProfiles("fitnesse");
            context.register(FixtureWirer.class);
            context.scan("org.moita.sb2");
            context.refresh();
            beanFactory = context.getAutowireCapableBeanFactory();
        }
        beanFactory.autowireBeanProperties(fixture, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
        beanFactory.autowireBean(fixture);
        beanFactory.initializeBean(fixture, fixture.getClass().getName());
    }
}