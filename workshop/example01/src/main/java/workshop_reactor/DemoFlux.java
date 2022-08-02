package workshop_reactor;

import reactor.core.publisher.Flux;

public class DemoFlux {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("A", "B", "C");
        flux.log()
            .map(i -> i.toLowerCase())
            .subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete")
        );
    }
}
