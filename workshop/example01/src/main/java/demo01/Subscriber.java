package demo01;

import java.util.concurrent.Flow;

public class Subscriber implements Flow.Subscriber<String> {
    private Flow.Subscription subscription;
    private int counter = 0;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        subscription.request(100);
    }

    @Override
    public void onNext(String item) {
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
