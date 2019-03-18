package org.moita.sb2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebmodelApplication {

    public static ApplicationContext run(String[] args)
    {
        return SpringApplication.run(WebmodelApplication.class, args);
    }

    public static void execute(String[] args) {
        run(args);
        // execute jobs
    }

	public static void main(String[] args) {
		execute(args);
	}
}
