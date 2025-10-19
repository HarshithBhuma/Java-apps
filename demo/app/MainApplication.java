package demo.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "demo.*" })
@EnableJpaRepositories("demo.repository")
@EntityScan("demo.domain")
@EnableCaching
public class MainApplication {
	public static void main(String args[]) {
		SpringApplication.run(MainApplication.class, args);
	}
}
