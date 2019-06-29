import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


/**
 * 通过Callable和FutureTask创建线程  
   a:创建Callable接口的实现类 ，并实现Call方法 
   b:创建Callable实现类的实现，使用FutureTask类包装Callable对象，该FutureTask对象封装了Callable对象的Call方法的返回值 
   c:使用FutureTask对象作为Thread对象的target创建并启动线程 
   d:调用FutureTask对象的get()来获取子线程执行结束的返回值

 *
 */

public class ThreadCreateTest3{
	
	  public static void main(String[] args) {

	        Callable<Object> oneCallable = new ThreadCreateTest31<Object>();
	        FutureTask<Object> oneTask = new FutureTask<Object>(oneCallable);
	        Thread t = new Thread(oneTask);
	        System.out.println(Thread.currentThread().getName());
	        t.start();

	    }
}
