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
		synchronized (buffer1) {
			synchronized (buffer2) {
				synchronized (buffer3) {
					while(running) {
						if(buffer3.getIndex()<=0) {
							try {
								System.out.println("b1阻塞");
								buffer1.wait();
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
						}
						if(buffer2.getIndex()<=0) {
							try {
								System.out.println("b2阻塞");
								buffer2.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						if(buffer3.getIndex()==buffer3.getCapacity()) {
							try {
								System.out.println("b3阻塞");
								buffer3.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
						buffer1.pop();
						buffer2.pop();
						buffer3.push(1);
						System.out.println("b1删除了元素");
						System.out.println("b2删除了元素");
						System.out.println("b3添加了元素");
						buffer3.notifyAll();
					}
					
				}
				
			}
			
		}
		while(running) {
			buffer1.pop();
			buffer2.pop();
			buffer3.push(1);
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
	public void mrun() {
		running=true;
	}

}
