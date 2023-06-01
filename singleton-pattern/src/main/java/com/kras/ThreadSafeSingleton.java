package com.kras;

public final class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton singleton;
    public String value;

    private ThreadSafeSingleton(String value) {
        this.value = value;
    }

    public static ThreadSafeSingleton getInstance(String value) {
        ThreadSafeSingleton result = singleton;
        if (result != null){
            return  result;
        }
        synchronized (ThreadSafeSingleton.class){
            if (singleton == null) {
                singleton = new ThreadSafeSingleton(value);
            }
            return singleton;
        }
    }
}
