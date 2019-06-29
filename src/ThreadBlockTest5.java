
/**
 *
 */
public class ThreadBlockTest5 implements Runnable {

	public volatile boolean isRunning = true;

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "开始执行！");
		while (isRunning) {
			for (int i = 1; i < 6; i++) {
				System.out.println(name + "执行了[" + i + "]次"); 
				Thread.yield();
			}
		}

		System.out.println(name + "执行结束！");
	}
	
	public static void main(String[] args) {
		
		ThreadBlockTest5 runnable1 = new ThreadBlockTest5();
		ThreadBlockTest5 runnable2 = new ThreadBlockTest5();
		Thread thread1 = new Thread(runnable1, "线程1");
		Thread thread2 = new Thread(runnable2, "线程2"); 
		
		System.out.println("两个线程准备开始执行");
		thread1.start();
		thread2.start();
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		runnable1.isRunning = false;
		runnable2.isRunning = false;
	}

}
