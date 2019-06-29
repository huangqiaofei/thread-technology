import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 *  ThreadPoolExecutor 
 *  可以看到每个任务都是是直接启动一个核心线程来执行任务，一共创建了6个线程，不会放入队列中。8秒后线程池还是6个线程，核心线程默认情况下不会被回收，不受超时时间限制。
 * @author yoyo
 *
 */
public class ThreadPoolExecutorTest1 {


	
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

		ThreadPoolExecutor executor = new ThreadPoolExecutor(6, 10, 5, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());
	
		// 核心线程数为6，最大线程数为10。超时时间为5秒
		
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
	/**
	 * 
	 */

}
