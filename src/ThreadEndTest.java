
public class ThreadEndTest extends Thread {

	public volatile boolean exit = false;

	public void run() {
		while (!exit)
			System.out.println("我还在~");
			;
	}

	public static void main(String[] args) throws Exception {
		ThreadEndTest thread = new ThreadEndTest();
		thread.start();
		sleep(5000); // 主线程延迟5秒
		thread.exit = true; // 终止线程thread
		thread.join();
		System.out.println("线程退出!");
	}

}
