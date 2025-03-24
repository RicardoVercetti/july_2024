package Java.Async;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SampleOne {

    // time record
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
    .withZone(ZoneId.systemDefault());

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        
        int number = 5;

        // System.out.println("Heyy");

        ExecutorService threadpool = Executors.newCachedThreadPool();
        Future<Long> futureTask = threadpool.submit(() -> factorial(number));

        System.out.println("Before time : " + getCurrentTime());
        while (!futureTask.isDone()) {
            // System.out.println("FutureTask is not finished yet. Current time :" + getCurrentTime());
            System.out.println("FutureTask is not finished yet.");
        }
        System.out.println("After time : " + getCurrentTime());
        
        long result = futureTask.get();
        System.out.println("Result is : " + result);

        threadpool.shutdown();

//         CompletableFuture<Long> completableFuture = CompletableFuture.supplyAsync(() -> factorial(number));
// while (!completableFuture.isDone()) {
//     System.out.println("CompletableFuture is not finished yet...");
// }
// long result = completableFuture.get();

        }

        public static long factorial(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Number must be non-negative.");
            }
            if (n == 0) {
                return 1;
            }
            return n * factorial(n - 1);
        }

        public static String getCurrentTime() {
            Instant now = Instant.now();
            return formatter.format(now);
        }
}
