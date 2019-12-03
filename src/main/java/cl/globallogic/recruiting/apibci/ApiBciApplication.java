package cl.globallogic.recruiting.apibci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(scanBasePackages = "cl.globallogic.recruiting.apibci")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
public class ApiBciApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiBciApplication.class, args);
    }

}
