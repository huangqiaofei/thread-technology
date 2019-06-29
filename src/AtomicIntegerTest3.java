import java.util.concurrent.atomic.AtomicInteger;

/**
 * atomicInteger 沒毛病
 *
 */
public class AtomicIntegerTest3 {
	
	public static AtomicInteger count = new AtomicInteger(0);

	public static void main(String[] args) throws Exception{ 
		
		for (int i = 0; i < 10000; i++) { 
			
			new Thread() {    
				
				public void run() {    
					 count.getAndIncrement();         
					}           
				}.start();      
			}   
		Thread.sleep(2000);
		System.out.println("atomicInteger count: " + count);
	}
}
