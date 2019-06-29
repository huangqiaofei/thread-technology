
/**
 * 指定时间执行
 */
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest3 {
	
	  Timer timer;
	  
	  public TimerTest3(){
	    Date time = getTime();
	    System.out.println("指定时间time="+time);
	    timer = new Timer();
	    timer.schedule(new TimerTaskTest1(),time);//timer.schedule(执行的方法，要执行的时间)
	  }
	 
	  public static Date getTime(){//设置执行时间
	    Calendar calendar = Calendar.getInstance();
	    calendar.set(Calendar.SECOND,10);
	    Date time = calendar.getTime();
	    return time;
	  }
	 
	  public static void main(String[] args) {
	    new TimerTest3();
	    while (true) {

	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	System.out.println(new Date());
		}
	  }
	 
	  class TimerTaskTest1 extends TimerTask{
	    public void run() {
	      System.out.println("指定时间执行线程任务...");
	    }
	  }
}
