
/**
 * 从执行结果可以看出，加入join()方法，主线程启动了子线程之后，在等待子线程执行完毕才继续执行下面的操作。
 *
 */
public class ThreadBlockTest4 implements Runnable {

	@Override
	public void run() {
		String name = Thread.currentThread().getName();
		System.out.println(name + "开始执行！");

		for (int i = 1; i < 10; i++) {
			System.out.println(name + "执行了[" + i + "]次");
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) throws Exception {
		ThreadBlockTest4 runnable1 = new ThreadBlockTest4();
		Thread thread1 = new Thread(runnable1, "线程1");

		System.out.println("主线程开始执行！");
		thread1.start();
		thread1.join(2000);

		System.out.println("主线程执行结束！");
	}

}
