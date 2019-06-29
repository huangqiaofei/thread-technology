
public class ThreadLocalTest1 {

	private static final ThreadLocal<Object> threadLocal = new ThreadLocal<Object>() {

		/**
		 * ThreadLocal没有被当前线程赋值时或当前线程刚调用remove方法后调用get方法，返回此方法值
		 */
		@Override
		protected Object initialValue() {

			System.out.println("调用get方法时，当前线程共享变量没有设置，调用initialValue获取默认值！");
			return null;
		}
	};

	public static void main(String[] args) {

	//	new Thread(new MyIntegerTask("IntegerTask1",10)).start();
		new Thread(new MyStringTask("StringTask1","x")).start();
	//	new Thread(new MyIntegerTask("IntegerTask2",20)).start();
		new Thread(new MyStringTask("StringTask2","p")).start();
	}

	public static class MyIntegerTask implements Runnable {
		
		private String name;
		private int startValue;
		
		MyIntegerTask(String name,int startValue) {
			this.name = name;
			this.startValue = startValue;
		}

		@Override
		public void run() {
			
			for (int i = 0; i < 5; i++) {
				System.out.println("线程" + name + "第：" + i + " 次运行");
				// ThreadLocal.get方法获取线程变量
				if (null == ThreadLocalTest1.threadLocal.get()) {
					// ThreadLocal.get方法设置线程变量
					ThreadLocalTest1.threadLocal.set(startValue);
					System.out.println("线程" + name + " value = null");
				} else {
					int num = (Integer) ThreadLocalTest1.threadLocal.get();
					ThreadLocalTest1.threadLocal.set(num + 1);
					System.out.println("线程" + name + " value = " + ThreadLocalTest1.threadLocal.get());
					if (i == 3) {
						ThreadLocalTest1.threadLocal.remove();
					}
				}
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public static class MyStringTask implements Runnable {
		private String name;
		private String preStr;

		MyStringTask(String name,String preStr) {
			this.name = name;
			this.preStr=preStr;
		}

		@Override
		public void run() {
			
			for (int i = 0; i < 5; i++) {
				System.out.println("线程" + name + "第：" + i + " 次运行");
				
				if (null == ThreadLocalTest1.threadLocal.get()) {
					ThreadLocalTest1.threadLocal.set(preStr);
					System.out.println("线程" + name + ": a");
				} else {
					String str = (String) ThreadLocalTest1.threadLocal.get();
					ThreadLocalTest1.threadLocal.set(str + "a");
					System.out.println("线程" + name + ": " + ThreadLocalTest1.threadLocal.get());
				}
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
