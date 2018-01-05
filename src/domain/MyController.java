package domain;

import java.util.ArrayList;
/**
 * buffer4 暂时没有用到
 * @author 黄为涛
 *
 */
public class MyController extends Thread{
	private static MyController c=null;
	
	private ArrayList<Integer> box1;
	private ArrayList<Integer> box2;
	private ArrayList<Integer> box3;
	private ArrayList<Integer> box4;
	
	private Buffer buffer1;
	private Buffer buffer2;
	private Buffer buffer3;
	//private Buffer buffer4;
	private Producer producer1;
	private Producer producer2;
	private Consumer consumer;
	private Composer composer;
	
	
	private MyController() {
		super();
		 box1=Box.getBox1();
		 box2=Box.getBox2();
		 box3=Box.getBox3();
		 box4=Box.getBox4();
		 buffer1=new Buffer(1,3,box1);
		 buffer2=new Buffer(2,3,box2);
		 buffer3=new Buffer(3,5,box3);
		 //buffer4=new Buffer(4,200,box4);
		 
		 producer1= new Producer(buffer1,10);
		 producer2= new Producer(buffer2,10);
		 composer= new Composer(buffer1,buffer2,buffer3);
		 consumer=new Consumer(buffer3,1);
		
	}
	
	public static void createController() throws InterruptedException{
		if(c==null) {
			c=new MyController();
		}
	}
	@Override
	public void run() {
		 new Thread(producer1).start();
		 new Thread(producer2).start();
		 new Thread(composer).start();
		 new Thread(consumer).start();
	}
	
	public static void crun() {
		if(c==null) {
			c=new MyController();
		}
		c.start();
	}
	
	
	
	
	
	
	

	public static void cstop() {
		c.producer1.mstop();
		c.producer2.mstop();
		c.composer.mstop();
		c.consumer.mstop();
	}
	public static void creset() throws InterruptedException {
		c.cstop();
		Thread.sleep(1000*1);
		c.box1.clear();
		c.box2.clear();
		c.box3.clear();
		c.box4.clear();
		 //c.buffer=new Buffer(10,c.box);			
		// c.p= new Producer(c.buffer,10);
		 //c.con=new Consumer(c.buffer,1);
	    c=null;

	}
}
