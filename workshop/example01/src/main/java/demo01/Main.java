package demo01;

import java.util.List;
import java.util.concurrent.SubmissionPublisher;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SubmissionPublisher<String> publisher = new SubmissionPublisher<>();
        MySubscriber subscriber = new MySubscriber();
        publisher.subscribe(subscriber);

        List<String> datas = getData();
        System.out.println("Publishing Items to Subscriber");
        datas.forEach(publisher::submit);
        System.out.println("Counter = " + subscriber.getCounter());
        publisher.close();
        System.out.println("Exiting the app");
//        Thread.sleep(5000);
//        System.out.println("Counter = " + subscriber.getCounter());
    }

    private static List<String> getData() {
        return Stream.generate(new Supplier<String>() {
            int i = 1;
            @Override
            public String get() {
                return "name " + (i++);
            }
        }).limit(100).collect(Collectors.toList());
    }
}
