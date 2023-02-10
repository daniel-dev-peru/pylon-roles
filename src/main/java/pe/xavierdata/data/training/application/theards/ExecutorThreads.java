package pe.xavierdata.data.training.application.theards;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ExecutorThreads {

  private ExecutorService executor = null;

  public ExecutorService getExecutor(){
    CustomThreadFactory customThreadFactory = new CustomThreadFactory("xav");
    ExecutorService executorService = Executors.newScheduledThreadPool(5, customThreadFactory);
    executor = executorService;
    return executor;
  }

}

class CustomThreadFactory implements ThreadFactory{
  private final AtomicInteger threadsNum = new AtomicInteger();

  private String namePattern;

  public CustomThreadFactory(String baseName){
    namePattern = baseName + "-%d";
  }

  @Override
  public Thread newThread(Runnable runnable){
    return new Thread(runnable, String.format(namePattern, threadsNum.addAndGet(1)));
  }
}