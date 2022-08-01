package reactor;

import reactor.core.publisher.Mono;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class DemoMono {
    public static void main(String[] args) {
        DemoMono demoMono = new DemoMono();
        demoMono.monoFromFutureAsync();
    }

    void mono01() {
        Mono<Integer> mono = Mono.just(1);
        mono.subscribe( i -> {
            System.out.println("Get data = " + i);
        });
    }

    void mono02WithError() {
        Mono<Integer> mono = Mono.just("Demo")
                .map(item -> item.length())
                .map(length -> length/0);
        mono.subscribe(
                item -> {
                    System.out.println(item);
                },
                error -> {
                    System.out.println(error.getMessage());
                },
                () -> {
                    System.out.println("Completed");
                });
        mono.subscribe(
                onNext(),
                onError(),
                onComplete());
    }

    public static Consumer<Object> onNext() {
        return o -> System.out.println("Received : " + o);
    }
    public static Consumer<Throwable> onError() {
        return e -> System.out.println("Error : " + e.getMessage());
    }
    public static Runnable onComplete() {
        return () -> System.out.println("Completed");
    }

    void monoFromFutureAsync() {
        Mono.fromFuture(getDataFromDB())
                .subscribe(item -> System.out.println(item));
    }

    public CompletableFuture<String> getDataFromDB() {
        return CompletableFuture.supplyAsync(() -> "Data from future");
    }


}
