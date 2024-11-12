package ftn.project.OnlyBunsBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlyBunsBackendApplication {
	private static StringBuilder stringBuilder = new StringBuilder();

	public static void main(String[] args) {
		SpringApplication.run(OnlyBunsBackendApplication.class, args);

		stringBuilder.append("Pozdrav!");
		System.out.println(stringBuilder.toString());
	}
}
