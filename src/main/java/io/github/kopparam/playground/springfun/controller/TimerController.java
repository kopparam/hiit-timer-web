package io.github.kopparam.playground.springfun.controller;

import io.github.kopparam.playground.springfun.model.HIITTimer;
import io.github.kopparam.playground.springfun.repository.HIITTimerRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/api/timer")
public class TimerController {
    @Autowired
    HIITTimerRepository repository;

    @PostMapping
    public @ResponseBody
    HIITTimer create(
            @RequestBody HIITTimer timer
    ) {
        return repository.save(timer);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    HIITTimer create(
            @PathVariable("id") UUID id,
            @RequestBody HIITTimer timer
    ) {
        timer.setId(id);
        return repository.save(timer);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Optional<HIITTimer> get(
            @PathVariable("id") UUID id
    ) {
        return repository.findById(id);
    }

    @GetMapping
    public @ResponseBody
    List<HIITTimer> get() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }
}
