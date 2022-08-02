package workshop_reactor;

import reactor.core.publisher.Mono;

public class DemoMono {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();
        userRepository.getById(1)
                .log()
                .subscribe(
                data -> System.out.println("Data = " + data),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Complete")
        );
    }
}

class UserRepository {
    Mono<String> getById(int id) {
        // 1. Success
        if(id == 1) {
            return Mono.just("User 1");
        }
        // 2. User not found
        if(id == 2) {
            return Mono.empty();
        }
        // 3. Error
        return Mono.error(new RuntimeException("Error with id = " + id));
    }
}
