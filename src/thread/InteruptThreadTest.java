package thread;

public class InteruptThreadTest {
	int i = 0;
	
	class IncrementThread implements Runnable {
		@Override
		public void run() {
			int count = 0;
			while (true) {
				count++;
				synchronized(this) {
					i++;
					System.out.println("increased : " + i);
				}
				if (count == 1000)
					return;
			}
		}
	}
	
	class DecrementThread implements Runnable {
		@Override
		public void run() {
			int count = 0;
			while (true) {
				count++;
				synchronized(this) {
					i--;
					System.out.println("decresed : " + i);
				}
				if (count == 1000)
					return;
			}
		}
	}
	
	public InteruptThreadTest() {
		Thread t1 = new Thread(new IncrementThread());
		Thread t2 = new Thread(new DecrementThread());
		t1.setPriority(10);
		t2.setPriority(1);
		
		t2.start();
		t1.start();
		
		try
		{
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new InteruptThreadTest();
	}

}
