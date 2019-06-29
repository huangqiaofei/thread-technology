
/**
 * t1.join() 方法会让 t1执行完 再继续执行 t2
 *
 */
public class ThreadBlockTest2 {

	    public static void main(String [] args) throws InterruptedException {
	        ThreadJoinTest t1 = new ThreadJoinTest("小明");
	        ThreadJoinTest t2 = new ThreadJoinTest("小东");
	        t1.start();
	        t1.join();
	        System.out.println("xxoo");
	        t2.start();
	    }

	}
	class ThreadJoinTest extends Thread{
	    public ThreadJoinTest(String name){
	        super(name);
	    }
	    @Override
	    public void run(){
	        for(int i=0;i<50;i++){
	        	try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            System.out.println(this.getName() + ":" + i);
	        }
	    }
	}
