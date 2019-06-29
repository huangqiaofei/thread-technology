
/**
 * 3s后开始执行，注意：只会执行一次
 */
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest2 {
	
	Timer timer;

	public TimerTest2(int time) {
		timer = new Timer();
		timer.schedule(new timerTaskTest(), time * 1000);// timer.schedule(执行的方法，延迟多久执行(ms))
	}


	class timerTaskTest extends TimerTask {
		@Override
		public void run() {
			System.out.println("time's up!!");
		}
	}
	
	
	public static void main(String[] args) {
		System.out.println("timer begin...");
		new TimerTest2(3);
	}
}
