
/**
 * 指定时间 每天执行
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest4 {
	 public void timerRun() {
		 System.out.println("定时器开始运行....");
	        // 一天的毫秒数
	        long daySpan = 24 * 60 * 60 * 1000;
	        String startTimeStr = "19:17:00";
			// 规定的每天具体时间运行
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd " + startTimeStr );
	        System.out.println("定时器将在每天：" + sdf.format(new Date()) + "执行" );
	        // 首次运行时间
	        try {
	            Date startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(sdf.format(new Date()));
	            // 如果今天的已经过了 首次运行时间就改为明天
	            if (System.currentTimeMillis() > startTime.getTime()){
	                startTime = new Date(startTime.getTime() + daySpan);
	            }
	            Timer t = new Timer();
	            TimerTask task = new TimerTask() {
	                @Override
	                public void run() {
	                    System.out.print("定时器执行");
	                }
	            };
	            // 以每24小时执行一次
	            t.schedule(task, startTime, daySpan);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public static void main(String[] args) {
	        new TimerTest4().timerRun();
	    }

}
