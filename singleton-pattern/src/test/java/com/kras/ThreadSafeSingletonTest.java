package com.kras;

import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

class ThreadSafeSingletonTest {
    private static final Logger logger = Logger.getLogger(ThreadSafeSingleton.class.getName());

    static class ThreadFirst implements Runnable {

        @Override
        public void run() {
            ThreadSafeSingleton firstThreadSingleton = ThreadSafeSingleton.getInstance("FirstThread");
            logger.info("Called FirstThread value: " + firstThreadSingleton.value);
        }
    }

    static class ThreadSecond implements Runnable {

        @Override
        public void run() {
            ThreadSafeSingleton secondThreadSingleton = ThreadSafeSingleton.getInstance("SecondThread");
            logger.info("Called SecondThread value: " + secondThreadSingleton.value);
        }
    }

    @Test
    void givenTwoThreads_whenGetInstance_thenReturnSingletonAndNoRaceCondition() throws InterruptedException {
        Thread threadOne = new Thread(new ThreadFirst());
        Thread threadTwo = new Thread(new ThreadSecond());
        threadOne.start();
        threadTwo.start();

        threadOne.join();
        threadTwo.join();
    }

}