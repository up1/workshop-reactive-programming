package reactor;

import reactor.core.publisher.Flux;

import java.util.List;
import java.util.stream.Stream;

public class DemoFlux {
    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5);
        Stream<Integer> stream = list.stream();

        Flux<Integer> flux = Flux.just(1, 2, 3, 4, 5);
//        Flux<Integer> flux = Flux.fromIterable(list);
//        Flux<Integer> flux = Flux.fromStream(stream);
        flux.subscribe(
                item -> System.out.println("Received : " + item),
                error -> System.out.println("Error : " + error.getMessage()),
                () -> System.out.println("Done"));

    }
}
