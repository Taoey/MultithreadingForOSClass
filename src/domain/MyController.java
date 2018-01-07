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
	private Buffer buffer4;
	
	private int P1N;
	private int P2N;
	private int composerNum;
	private int consumerNum;
	private int speedP1;
	private int speedP2;
	private int composerSpeed;
	private int consumerSpeed;
	
	private ArrayList<Producer>producer1List;
	private ArrayList<Producer>producer2List;
	private ArrayList<Composer>composerList;
	private ArrayList<Consumer>consumerList;

	
	/**
	 * 
	 * @param B1C          buffer1的容量
	 * @param B2C
	 * @param B3C
	 * @param P1N          生产线1工人数量
	 * @param speedP1                    生产线1工人速度
	 * @param P2N
	 * @param speedP2
	 * @param composerNum  组装者数量     
	 * @param speedCom     组装者速度
	 * @param consumerNum  消费者数量
	 * @param speedCon     消费者速度
	 * 
	 */
	private MyController(int B1C,int B2C,int B3C,int P1N,int speedP1,int P2N,int speedP2,int composerNum,int speedCom,int consumerNum,int speedCon) {
		super();
		 box1=Box.getBox1();
		 box2=Box.getBox2();
		 box3=Box.getBox3();
		 box4=Box.getBox4();
		 buffer1=new Buffer(1,B1C,box1);
		 buffer2=new Buffer(2,B2C,box2);
		 buffer3=new Buffer(3,B3C,box3);
		 buffer4=new Buffer(4,1000,box4);//设置buffer4的默认容量为1000；
		 
		 this.P1N=P1N;
		 this.speedP1=speedP1;
		 this.P2N=P2N;
		 this.speedP1=speedP1;
		 this.composerNum=composerNum;
		 this.composerSpeed=composerSpeed;
		 this.consumerNum=consumerNum;
		 this.consumerSpeed=consumerNum;
		 
		 producer1List =new ArrayList<>();
		 producer2List =new ArrayList<>();
		 composerList =new ArrayList<>();
		 consumerList =new ArrayList<>();
		 
		 
		for(int i=0;i<P1N;i++) {
			Producer producer = new Producer(buffer1,speedP1);
			producer1List.add(producer);
		}
		for(int i=0;i<P2N;i++) {
			Producer producer = new Producer(buffer2,speedP2);
			producer2List.add(producer);
		}
		for(int i=0;i<composerNum;i++) {
			Composer composer = new Composer(buffer1,buffer2,buffer3,composerSpeed);
			composerList.add(composer);
		}
	}
	
	public static void createController(int B1C,int B2C,int B3C,int P1N,int speedP1,int P2N,int speedP2,int composerNum,int speedCom,int consumerNum,int speedCon) throws InterruptedException{
		if(c==null) {
			c=new MyController( B1C, B2C, B3C, P1N, speedP1, P2N, speedP2, composerNum,speedCom,consumerNum, speedCon);
			
		}
	}
	@Override
	public void run() {
		for(int i=0;i<producer1List.size();i++) {
			new Thread(producer1List.get(i)).start();
		}
		for(int i=0;i<producer2List.size();i++) {
			new Thread(producer2List.get(i)).start();

		}
		for(int i=0;i<composerList.size();i++) {
			new Thread(composerList.get(i)).start();
	    }
		


//		for(int i=0;i<consumerNum;i++) {
//			Consumer consumer = new Consumer(buffer3,buffer4,consumerSpeed);
//			consumerList.add(consumer);
//			new Thread(consumer).start();
//		}
	}
	public static void crun(int B1C,int B2C,int B3C,int P1N,int speedP1,int P2N,int speedP2,int composerNum,int speedCom,int consumerNum,int speedCon) {
		if(c==null) {
			c=new MyController( B1C, B2C, B3C, P1N, speedP1, P2N, speedP2, composerNum,speedCom,consumerNum, speedCon);
		}
		c.start();
	}
	
	
	
	
	
	
	

	public static void cstop() {
		for(int i=0;i<c.producer1List.size();i++) {
			c.producer1List.get(i).mstop();
		}
		for(int i=0;i<c.producer2List.size();i++) {
			c.producer2List.get(i).mstop();
		}
		for(int i=0;i<c.composerList.size();i++) {
			c.composerList.get(i).mstop();
		}
		for(int i=0;i<c.composerList.size();i++) {
			c.composerList.get(i).mstop();
		}
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
