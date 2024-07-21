package Java.Patterns.Balking;

import java.util.concurrent.TimeUnit;

public interface DelayProvder {
    void executeAfterDelay(long interval, TimeUnit timeUnit, Runnable task);
}
