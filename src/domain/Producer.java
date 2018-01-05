package domain;

public class Producer implements Runnable{
	private Buffer buffer;
	private int speed;
	
	
	public Producer(Buffer buffer) {
		this.buffer=buffer;
		speed=6000;
	}
	
	public Producer(Buffer buffer,int speed) {
		this.speed=speed;
		this.buffer = buffer;
	}
		
	@Override
	public void run() {
		while(true) {
			int pushNum=(int) (Math.random()*100);
			buffer.push(pushNum);
			
			try {
				Thread.sleep(1000);
				
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
	
	


}
