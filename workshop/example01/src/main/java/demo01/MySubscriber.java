package demo01;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

public class MySubscriber implements Subscriber<String> {
    private Subscription subscription;
    private int counter = 0;

    @Override
    public void onSubscribe(Subscription subscription) {
        this.subscription = subscription;
        subscription.request(100);
    }

    @Override
    public void onNext(String item) {
//        try {
//            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println("Process item = " + item);
        counter++;
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println(this.getClass().getName() + " an error occured " + throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("activity completed");
    }

    public int getCounter() {
        return counter;
    }

}
