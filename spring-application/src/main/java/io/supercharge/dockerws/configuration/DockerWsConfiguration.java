package io.supercharge.dockerws.configuration;

import org.ajbrown.namemachine.NameGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DockerWsConfiguration {

    @Bean
    public NameGenerator nameGenerator() {
        return new NameGenerator();
    }
}
