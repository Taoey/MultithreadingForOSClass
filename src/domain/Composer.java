package domain;

public class Composer implements Runnable{
	
	private Buffer buffer1;
	private Buffer buffer2;
	private Buffer buffer3;
	private int speed;
	private boolean running;
	
	public Composer(Buffer resource1,Buffer resource2,Buffer destination) {
		buffer1=resource1;
		buffer2=resource2;
		buffer3=destination;
		speed=6000;
		running=true;
	}
	public Composer(Buffer resource1,Buffer resource2,Buffer destination, int speed) {
		buffer1=resource1;
		buffer2=resource2;
		buffer3=destination;
		this.speed=speed;
		running=true;
	}
	
	
	
	@Override
	public void run() {
		while(running) {
			buffer1.pop();
			buffer2.pop();
			buffer3.push(1);
			try {
				Thread.sleep(1000);
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
