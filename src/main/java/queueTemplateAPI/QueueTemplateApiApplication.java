package queueTemplateAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
public class QueueTemplateApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueTemplateApiApplication.class, args);
	}

}
