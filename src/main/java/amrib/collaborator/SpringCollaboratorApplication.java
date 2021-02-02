package amrib.collaborator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import amrib.collaborator.entity.AddressEntity;
import amrib.collaborator.entity.CompanyEntity;

@Configuration
@ComponentScan(basePackageClasses = CompanyEntity.class)
class Config {
	@Bean
	public AddressEntity getAdress() {
		return new AddressEntity("High venue", 3);
	}
}

@SpringBootApplication
public class SpringCollaboratorApplication {
	/**
	 * @param args
	 */

	public static void verifyValueOfBeans() {
		@SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		System.out.println("Hello World");
		CompanyEntity ent = context.getBean("companyEntity", CompanyEntity.class);
		System.out.println(ent.getAddress().getStreet());
		System.out.println(ent.getAddress().getNumber());
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCollaboratorApplication.class, args);
		verifyValueOfBeans();
	}
}
