package workshop_reactor;

import reactor.core.publisher.Mono;

public class DemoReactor {
    public static void main(String[] args) {
        // Publisher
        Mono<String> mono = Mono.just("demo data");
        // Subscriber => onNext(item), onError(error), onComplete()
        mono.subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Complete")
        );

        Mono<Integer> mono2 = Mono.just("demo data")
                .map(data -> data.length())
                .map(len -> len/0);
        mono2.subscribe(
                item -> System.out.println(item),
                error -> System.out.println("Error with " + error.getMessage()),
                () -> System.out.println("Complete")
        );
    }
}
