
public class ThreadPriorityTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
            	while(true) {
            		System.out.println("\t" + Thread.currentThread().getName());
            		try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
            	}
            }
        };

        Thread t1 = new Thread(runnable, "A=============================================");
        Thread t2 = new Thread(runnable, "B===========");
        Thread t3 = new Thread(runnable, "C====");
        t1.setPriority(10);
        t2.setPriority(1);
        t3.setPriority(1);
        t1.start();
        t2.start();
        t3.start();
    }

}
