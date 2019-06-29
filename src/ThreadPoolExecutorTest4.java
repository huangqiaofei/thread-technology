import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 *  ThreadPoolExecutor 
 *  LinkedBlockingDeque根本不受最大线程数影响。  但是当LinkedBlockingDeque有大小限制时就会受最大线程数影响了

 * @author yoyo
 *
 */
public class ThreadPoolExecutorTest4 {


	
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

		ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 4, 5, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
	
		// 核心线程数是3，最大线程数是4，队列是LinkedBlockingDeque
		
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		System.out.println("---先开六个---");
		System.out.println("核心线程数" + executor.getCorePoolSize());
		System.out.println("线程池数" + executor.getPoolSize());
		System.out.println("队列任务数" + executor.getQueue().size());
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		executor.execute(myRunnable);
		System.out.println("---再开六个---");
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
