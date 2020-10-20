package be.multimedi.jammik.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import javax.persistence.EntityManager;

@Configuration
public class RestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;
}