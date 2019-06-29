import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 *  ThreadPoolExecutor 
 *  当队列是SynchronousQueue时，超出核心线程的任务会创建新的线程来执行，看到一共有6个线程。
 *  但是这些线程是核心线程，受超时时间限制，在任务完成后限制超过5秒就会被回收。所以最后看到线程池还是只有三个线程。
 * @author yoyo
 *
 */
public class ThreadPoolExecutorTest3 {


	
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

		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
	
		// 核心线程数为3，最大线程数为6。超时时间为5秒,队列是SynchronousQueue。
		
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
