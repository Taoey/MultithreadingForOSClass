package domain;

public class Consumer implements Runnable {

	private Buffer buffer3;
	private Buffer buffer4;
	
	private int speed;
	private boolean running;
	
	public Consumer() {
	}
	/**
	 * 消费者构造函数
	 * @param popB  消费者从该buffer中获取资源
	 * @param pushB 消费者将获取到的资源移入该buffer
	 * @param speed 消费者获取资源的速度（每秒获取speed个资源）
	 */
	public Consumer(Buffer popB,Buffer pushB,int speed) {
		this.speed=speed;
		this.buffer3=popB;
		this.buffer4 = pushB;
		running=true;
	}
		
	@Override
	public void run() {
		synchronized (buffer3) {
			synchronized (buffer4) {
				while(running) {
					if(buffer3.getList().size()<0) {
						try {
							System.out.println("b3阻塞");
							buffer3.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					buffer3.pop();
					buffer4.push(1);
					System.out.println("b3添加了元素");
				}
			}
			
		}
		
		while(running) {
			buffer3.pop();
			buffer4.push(1);
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
