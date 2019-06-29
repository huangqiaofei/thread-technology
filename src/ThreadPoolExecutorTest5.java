import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 *  ThreadPoolExecutor 
 *  LinkedBlockingDeque根本不受最大线程数影响。  但是当LinkedBlockingDeque有大小限制时就会受最大线程数影响了
 *  首先为三个任务开启了三个核心线程1，2，3，然后第四个任务和第五个任务加入到队列中，第六个任务因为队列满了，就直接创建一个新线程4，
 *  这是一共有四个线程，没有超过最大线程数。8秒后，非核心线程受超时时间影响回收了，因此线程池只剩3个线程了。
 * @author yoyo
 *
 */
public class ThreadPoolExecutorTest5 {


	
	public static void main(String[] args) throws Exception {
		Runnable myRunnable = new Runnable() {
		    @Override
		    public void run() {
		        try {
		            Thread.sleep(2000);
		            System.out.println(Thread.currentThread().getName() + " run");
		        } catch (InterruptedException e) {
		            e.printStackTrace();
		        }

		    }
		};

		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(1));
	
		
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		System.out.println("---先开三个---");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);

		System.out.println("---再开三个---");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		Thread.sleep(8000);
		System.out.println("----8秒之后----");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());

	}

}
