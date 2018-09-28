package com.example.demo.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ThreadPoolExecutorTest {

    public static final Logger LOGGER = LoggerFactory.getLogger(ThreadPoolExecutorTest.class);

    public static void main(String[] args) {
        int corePoolSize = 1;
        int maxPoolSize = 2;
        int blockingQueueCapacity = 9;
        int executorTaskSize = 12;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, 20, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(blockingQueueCapacity),
                r -> {
                    Thread thread = new Thread(r);
                    return thread;
                }, new ThreadPoolExecutor.DiscardOldestPolicy());


        IntStream.range(0, executorTaskSize)
                .boxed()
                .forEach(i -> {
                    threadPoolExecutor.execute(() -> {
                        try {
                            LOGGER.info("---> " + Thread.currentThread().getName());
                            TimeUnit.SECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    });
                });

        int activeCount = -1;
        int queueSize = -1;
        LOGGER.info("=========== < 开始监控 > =============");
        while (true) {
            if (activeCount != threadPoolExecutor.getActiveCount()
                    || queueSize != threadPoolExecutor.getQueue().size()) {
                LOGGER.info("正在运行的线程数: " + threadPoolExecutor.getActiveCount());
                LOGGER.info("核心线程数: " + threadPoolExecutor.getCorePoolSize());
                LOGGER.info("最大线程数: " + threadPoolExecutor.getMaximumPoolSize());
                LOGGER.info("等待队列中的线程数: " + threadPoolExecutor.getQueue().size());
                LOGGER.info(" ========================================================== ");
                activeCount = threadPoolExecutor.getActiveCount();
                queueSize = threadPoolExecutor.getQueue().size();
            }
        }
    }


}
