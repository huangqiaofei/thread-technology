import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/**
 *  ThreadPoolExecutor 
 *
 *  这次在添加第五个任务时就报错了，因为SynchronousQueue各奔不保存任务，收到一个任务就去创建新线程。所以第五个就会抛异常了。
 * @author yoyo
 *
 */
public class ThreadPoolExecutorTest6 {


	
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
