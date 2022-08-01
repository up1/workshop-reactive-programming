package reactor;

import reactor.core.publisher.Mono;

public class DemoMono2 {
    public static void main(String[] args) {
        DemoMono2 demoMono2 = new DemoMono2();
        demoMono2.start();
    }

    private void start() {
        userRepository(1).subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed with 1")
        );
        userRepository(2).subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed with 2")
        );
        userRepository(10).subscribe(
                item -> System.out.println(item),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Completed with 10")
        );
    }

    private Mono<String> userRepository(int userId) {
        if (userId == 1) {
            return Mono.just("Found user id " + userId);
        } else if (userId == 2) {
            // Data not found
            return Mono.empty();
        } else {
            return Mono.error(new RuntimeException("Error with user id " + userId));
        }

    }
}
