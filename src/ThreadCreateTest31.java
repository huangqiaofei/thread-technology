import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;


public class ThreadCreateTest31<Object> implements Callable<Object>{

		@Override
		public Object call() throws Exception {
			
			 System.out.println(Thread.currentThread().getName()+"-->我是通过实现Callable接口通过FutureTask包装器来实现的线程");
			 return null;
	  }
}
