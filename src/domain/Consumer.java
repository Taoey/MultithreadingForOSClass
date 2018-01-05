package domain;

public class Consumer implements Runnable {

	private Buffer buffer;
	private int speed;
	
	
	public Consumer(Buffer buffer) {
		this.buffer=buffer;
		speed=6000;
	}
	
	public Consumer(Buffer buffer,int speed) {
		this.speed=speed;
		this.buffer = buffer;
	}
		
	@Override
	public void run() {
		while(true) {
			buffer.pop();
			
			try {
				Thread.sleep(3*1000);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	
	
}
