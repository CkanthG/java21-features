package org.sree.features;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

public class ThreadComparison {

    private static final int NUM_TASKS = 1000;
    public static void main(String[] args) throws InterruptedException {
        // Testing with Platform or Traditional Threads
        System.out.println("Running tasks with Platform Threads...");
        Instant platformStart = Instant.now();
        runWithPlatformOrTraditionalThreads();
        Instant platformEnd = Instant.now();
        System.out.println(STR."Platform or Traditional Threads execution time: \{Duration.between(platformStart, platformEnd).toMillis()} ms");

        // Testing with Virtual Threads
        System.out.println("\nRunning tasks with Virtual Threads...");
        Instant virtualStart = Instant.now();
        runWithVirtualThreads();
        Instant virtualEnd = Instant.now();
        System.out.println(STR."Virtual Threads execution time: \{Duration.between(virtualStart, virtualEnd).toMillis()} ms");
    }

    private static void simulateTask(int taskId) {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            System.out.println(STR."Thread Execution Exception : \{e.getMessage()}");
        }
    }

    private static void runWithPlatformOrTraditionalThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < NUM_TASKS; i ++) {
            int taskId = i;
            Thread thread = new Thread(() -> simulateTask(taskId));
            threads.add(thread);
            thread.start();
        }
        // Wait for all threads to complete
        for (Thread thread : threads) {
            thread.join();
        }
    }

    private static void runWithVirtualThreads() throws InterruptedException {
        try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
            List<Runnable> tasks = new ArrayList<>();

            for (int i = 0; i < NUM_TASKS; i++) {
                int taskId = i;
                tasks.add(() -> simulateTask(taskId));
            }
            // Submit all tasks for execution
            tasks.forEach(executor::submit);
        }
    }
}
