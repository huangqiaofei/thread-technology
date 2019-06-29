/**
 * 输出的结果为count: 999x，这个值不固定，每次测试都可能不一样，很显然，多线程跑++操作，结果并没有像预期的那样count: 10000。
 *
 */
public class AtomicIntegerTest1 {

	public static int count = 0;

	public static void main(String[] args) throws Exception{

		for (int i = 0; i < 10000; i++) {

			new Thread(() -> {
				count++;
				//	count = count +1;
			}).start();
		}
		Thread.sleep(2000);
		System.out.println("count: " + count);
	}
}
