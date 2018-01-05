package domain;

public class Consumer implements Runnable {

	private Buffer buffer;
	private int speed;
	private boolean running;
	
	public Consumer(Buffer buffer) {
		this.buffer=buffer;
		speed=6000;
		running=true;
	}
	
	public Consumer(Buffer buffer,int speed) {
		this.speed=speed;
		this.buffer = buffer;
		running=true;
	}
		
	@Override
	public void run() {
		while(running) {
			buffer.pop();
			
			try {
				Thread.sleep(3*1000);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void mstop() {
		running=false;
	}

	
	
	
	
}
