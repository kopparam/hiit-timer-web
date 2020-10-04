package io.github.kopparam.playground.springfun.repository;

import io.github.kopparam.playground.springfun.model.HIITTimer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface HIITTimerRepository extends CrudRepository<HIITTimer, UUID> {
}
