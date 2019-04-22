package thread;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchDemo implements Runnable {
  
  static final CountDownLatch end = new CountDownLatch(10);
  static final CountDownLatchDemo demo =  new CountDownLatchDemo();

  @Override
  public void run() {
    // TODO Auto-generated method stub
    try{
      long time = new Random().nextInt(7)*1000;
      System.out.println("wait "+time);
      Thread.sleep(time);
      System.out.println(time+" seconds check complete");
      end.countDown();
    }catch (Exception e) {
      // TODO: handle exception
      e.printStackTrace();
    }
  }
  
  public static void main(String[] args) throws InterruptedException {
    
    long start = System.currentTimeMillis();
    
    ExecutorService exec =  Executors.newFixedThreadPool(10);
    for (int i = 0; i < 10; i++) {
      exec.submit(demo);
    }
    
    end.await();
    
    System.out.println("Fire!");
    
    exec.shutdown();
    
    System.out.println(System.currentTimeMillis() - start);
    
  }

  
  
  
}
