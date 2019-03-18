package org.moita.sb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class WebmodelApplication {

    public static ApplicationContext run(String[] args)
    {
        return SpringApplication.run(WebmodelApplication.class, args);
    }

	public static void main(String[] args) {
		run(args);
	}
}
