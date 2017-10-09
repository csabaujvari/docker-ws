package io.supercharge.dockerws.scheduler;

import io.supercharge.dockerws.domain.NameEntity;
import io.supercharge.dockerws.repository.NameRepository;
import org.ajbrown.namemachine.Name;
import org.ajbrown.namemachine.NameGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RandomScheduler {

    private static final Logger LOGGER = LoggerFactory.getLogger(RandomScheduler.class);
    private final NameRepository nameRepository;
    private final NameGenerator nameGenerator;

    public RandomScheduler(NameRepository nameRepository, NameGenerator nameGenerator) {
        this.nameRepository = nameRepository;
        this.nameGenerator = nameGenerator;
    }

    @Scheduled(cron = "*/10 * * * * *")
    public void generateDbRecord() {
        LOGGER.info("Generating new name");
        Name name = nameGenerator.generateName();

        LOGGER.info("Creating new NameEntity");
        NameEntity nameEntity = new NameEntity();
        nameEntity.setGender(name.getGender());
        nameEntity.setFirstName(name.getFirstName());
        nameEntity.setLastName(name.getLastName());

        nameRepository.save(nameEntity);
        LOGGER.info("NameEntity saved successfully");
    }
}
