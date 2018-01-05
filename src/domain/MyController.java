package domain;

import java.util.ArrayList;

public class MyController extends Thread{
	private static MyController c=null;
	
	private ArrayList<Integer> box;
	private Buffer buffer;		
	private Producer p;
	private Consumer con;			
	
	
	private MyController() {
		super();
		 box=Box.getBox1();
		 buffer=new Buffer(10,box);			
		 p= new Producer(buffer,10);
		 con=new Consumer(buffer,1);
	}
	
	@Override
	public void run() {
		 new Thread(con).start();
		 new Thread(p).start();
	}
	
	public static void createController() throws InterruptedException{
		if(c==null) {
			c=new MyController();
		}
	}
	
	
	
	
	
	
	
	public static void crun() {
		if(c==null) {
			c=new MyController();
		}
		c.start();
	}
	public static void cstop() {
		c.con.mstop();
		c.p.mstop();
	}
	public static void creset() throws InterruptedException {
		c.cstop();
		Thread.sleep(1000*1);
		c.box.clear();
		 //c.buffer=new Buffer(10,c.box);			
		// c.p= new Producer(c.buffer,10);
		 //c.con=new Consumer(c.buffer,1);
	    c=null;

	}
}
