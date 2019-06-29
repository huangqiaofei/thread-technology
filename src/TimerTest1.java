
/**
 * 3s后开始执行，每秒执行一次
 */
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest1 {
	public static void main(String[] args) {

		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			public void run() {
				System.out.println("11232");
			}
		}, 3000, 1000);
	}
}
