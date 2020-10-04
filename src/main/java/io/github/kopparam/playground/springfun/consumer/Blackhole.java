package io.github.kopparam.playground.springfun.consumer;

import org.springframework.kafka.annotation.KafkaListener;

public class Blackhole {

    @KafkaListener
    void blackhole() {

    }
}
