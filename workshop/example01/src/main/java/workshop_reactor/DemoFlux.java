package workshop_reactor;

import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class DemoFlux {
    public static void main(String[] args) {
        Flux<String> flux = Flux.just("A", "B", "C");
        flux.log()
            .map(i -> i.toLowerCase())
//            .subscribeOn(Schedulers.newParallel("sub"))
//            .publishOn(Schedulers.newParallel("pub"))
            .subscribe(
                item -> System.out.println(item),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete")
        );
        System.out.println("Done");
    }
}
