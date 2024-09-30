package org.sree.features;

public class VirtualThreadsExample {
    public static void main(String[] args) {
        Runnable run = () -> {
            System.out.println("Runnable Run Method Executed ...");
        };
        long threadId = Thread.startVirtualThread(run).threadId();
        System.out.println(STR."Thread ID : \{threadId}");
    }
}
