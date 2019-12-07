package cl.globallogic.recruiting.apibci;

import cl.globallogic.recruiting.apibci.model.User;
import cl.globallogic.recruiting.apibci.repository.UserRepository;
import cl.globallogic.recruiting.apibci.service.UserServiceImpl;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@SpringBootApplication(scanBasePackages = "cl.globallogic.recruiting.apibci")
public class ApiBciApplication implements CommandLineRunner {

    private static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(ApiBciApplication.class, args);
    }

    public void run(String... arg0) throws Exception {
        User u = new User();
        u.setId(UUID.randomUUID().toString());
        u.setActive(true);
        u.setCreated(LocalDateTime.now());
        u.setName("admin");
        u.setPassword("Admin12");
        u.setEmail("admin@bci.cl");
        userRepository.save(u);
    }

    @Bean
    public Jackson2ObjectMapperBuilder jacksonBuilder() {
        Jackson2ObjectMapperBuilder builder = new Jackson2ObjectMapperBuilder();
        builder.propertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);

        builder.simpleDateFormat(DEFAULT_DATE_FORMAT);
        builder.serializers(new LocalDateSerializer(DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT)));

        return builder;
    }
}
