package com.czht.smartpark.tbweb.modular.asyntask;

import java.util.TimerTask;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 任务管理器，这里执行任务
 */
public class TaskManager {

    /**
     * 异步任务现成池
     */
    private ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

    private TaskManager(){}

    public static TaskManager manager = new TaskManager();

    public static TaskManager getInstance() { return manager;};

    public void excute(TimerTask task){
        executor.schedule(task, 10, TimeUnit.MILLISECONDS);
    }

}
