package com.discobird.discobird;

import com.discobird.discobird.domain.Bird;
import com.discobird.discobird.repository.BirdRepository;
import com.discobird.discobird.service.BirdService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {


    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
