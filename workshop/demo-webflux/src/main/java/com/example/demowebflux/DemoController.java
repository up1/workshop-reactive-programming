package com.example.demowebflux;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public Mono callSlow() {
        return Mono.defer(() -> Mono.just("Success with slow"))
                .delaySubscription(Duration.ofMillis(1000));
    }

}
