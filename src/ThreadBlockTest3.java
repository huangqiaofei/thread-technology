
/**
 * join方法中如果传入参数，则表示这样的意思：如果A线程中掉用B线程的join(10)，则表示A线程会等待B线程执行10毫秒，10毫秒过后，A、B线程并行执行。
 * 需要注意的是，jdk规定，join(0)的意思不是A线程等待B线程0秒，而是A线程等待B线程无限时间，直到B线程执行完毕，即join(0)等价于join()。
 *
 */
public class ThreadBlockTest3 {

	    public static void main(String [] args) throws InterruptedException {
	    	ThreadJoinTest2 t1 = new ThreadJoinTest2("小明");
	    	ThreadJoinTest2 t2 = new ThreadJoinTest2("小东");
	        t1.start();
	        t1.join(Long.MAX_VALUE);
	        // join 阻塞 5秒 线程 上一级
	        System.out.println("xxoo");
	        t2.start();
	         // 三线程 同时执行
	    }

	}
	class ThreadJoinTest2 extends Thread{
	    public ThreadJoinTest2(String name){
	        super(name);
	    }
	    @Override
	    public void run(){
	        for(int i=0;i<10;i++){
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
