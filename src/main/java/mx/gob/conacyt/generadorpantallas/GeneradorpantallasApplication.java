package mx.gob.conacyt.generadorpantallas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class GeneradorpantallasApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplicationBuilder(GeneradorpantallasApplication.class)
				.web(WebApplicationType.NONE).build();
		app.run(args);
	}

}
