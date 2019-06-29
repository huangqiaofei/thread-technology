/**
 * volatile仅仅保证变量在线程间保持可见性，却依然不能保证非原子性的操作。
 *
 */
public class AtomicIntegerTest2 {
	
	public static volatile int count = 0;

	public static void main(String[] args) throws Exception{ 
		
		for (int i = 0; i < 10000; i++) { 
			
			new Thread() {    
				
				public void run() {    
					count++;         
					}           
				}.start();      
			}   
		Thread.sleep(2000);
		System.out.println("volatile count: " + count);
	}
}
