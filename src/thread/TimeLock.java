package thread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {

  public static ReentrantLock lock = new ReentrantLock();

  @Override
  public void run() {
    System.out.println("bbb");
    try {
      if (lock.tryLock(5, TimeUnit.SECONDS)) {
        System.out.println("aaa");
        Thread.sleep(6000);
      } else {
        System.out.println("get lock failed");
      }
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      if (lock.isHeldByCurrentThread()) {
        System.out.println("ssss");
        lock.unlock();
      }
    }
  }
  
  public static void main(String[] args) {
    TimeLock tl = new TimeLock();
    Thread t1 = new Thread(tl);
    Thread t2 = new Thread(tl);
    t1.start();
    t2.start();
  }
  
}
