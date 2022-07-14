package com.git.test.GitTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class GitTest {
    public static void main(String[] args) {
        System.out.println("hello,git");
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        ArrayList<String> objects = new ArrayList<>();
        ArrayBlockingQueue<Runnable> runnable = new ArrayBlockingQueue<>(5);
        ThreadFactory threadFactory = Executors.defaultThreadFactory();
        ThreadPoolExecutor.AbortPolicy abortPolicy = new ThreadPoolExecutor.AbortPolicy();
        ThreadPoolExecutor pool
                = new ThreadPoolExecutor(2, 3, 60, TimeUnit.SECONDS, runnable, threadFactory, abortPolicy);
        Set set = new HashSet();
        HashMap<Object, Object> hashMap = new HashMap<>();
        System.out.println("6664");
    }
}
