package ua.vld.config;


import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
@Profile("jsondata")
public class JsonDataConfig {
    @Bean
    public Gson gson() {
        return new Gson();
    }
}
