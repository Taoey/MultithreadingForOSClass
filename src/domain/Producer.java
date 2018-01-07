package domain;

public class Producer implements Runnable{
	private Buffer buffer;
	private int speed;
	private boolean running;
	
	public Producer(Buffer buffer,int speed) {
		this.speed=speed;
		this.buffer = buffer;
		running=true;
	}
		
	@Override
	public void run() {
		while(running) {
			int pushNum=(int) (Math.random()*100);
			buffer.push(pushNum);
			
			try {
				Thread.sleep(speed*1000);
				
				
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
