package io.github.kopparam.playground.springfun.controller;

import io.github.kopparam.playground.springfun.model.HIITTimer;
import io.github.kopparam.playground.springfun.repository.HIITTimerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/timer")
public class TimerController {
    @Autowired
    HIITTimerRepository repository;

    @PostMapping
    public @ResponseBody HIITTimer create(
            @RequestBody HIITTimer timer
    ) {
        HIITTimer save = repository.save(timer);
        return save;
    }
}
