package regex.keyboard;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("regex.keyboard.domain.repository")
@SpringBootApplication
public class RegexKeyboardApplication {
    public static void main(String[] args) {
        SpringApplication.run(RegexKeyboardApplication.class, args);
    }
}
