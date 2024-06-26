package enigma.tokonyadia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TokonyadiaApplication {
	// customer dalam bentuk array
	// customer di springboot yang connect ke DB
	public static void main(String[] args) {
		SpringApplication.run(TokonyadiaApplication.class, args);
	}

}
