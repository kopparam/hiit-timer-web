package io.github.kopparam.playground.springfun.repository;

import io.github.kopparam.playground.springfun.model.HIITTimer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.UUID;

@RepositoryRestResource(path = "timer", collectionResourceRel = "timers", itemResourceRel = "timer")
public interface HIITTimerRepository extends PagingAndSortingRepository<HIITTimer, UUID> {
}
