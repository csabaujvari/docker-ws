package io.supercharge.dockerws.repository;

import io.supercharge.dockerws.domain.NameEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends JpaRepository<NameEntity, Long> {
}
