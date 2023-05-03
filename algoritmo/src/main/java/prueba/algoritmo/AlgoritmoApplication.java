package prueba.algoritmo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { ErrorMvcAutoConfiguration.class })
@ComponentScan(basePackages = {"prueba.algoritmo.service"})
@EntityScan("prueba.algoritmo.entities")
public class AlgoritmoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlgoritmoApplication.class, args);
	}

}
