package domain;

import java.util.Vector;
import java.util.Vector;
/**
 * buffer4 暂时没有用到
 * @author 黄为涛
 *
 */
public class MyController extends Thread{
	private static MyController c=null;
	
	private Vector<Integer> box1;
	private Vector<Integer> box2;
	private Vector<Integer> box3;
	private Vector<Integer> box4;
	
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
	
	private Vector<Producer>producer1List;
	private Vector<Producer>producer2List;
	private Vector<Composer>composerList;
	private Vector<Consumer>consumerList;
	
	Producer p1;
	Producer p2;
	Composer com ;
	Consumer con;
	
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
		 
		 
		 this.consumerNum=consumerNum;
		 this.consumerSpeed=consumerSpeed;
		 p1=new Producer(buffer1, speedP1);
		 p2=new Producer(buffer2, speedP2);
		 com =new Composer(buffer1,buffer2,buffer3, speedCom);
		 //con =new Consumer(buffer3,buffer4,speedCon);

	}
	
	public static void createController(int B1C,int B2C,int B3C,int P1N,int speedP1,int P2N,int speedP2,int composerNum,int speedCom,int consumerNum,int speedCon) throws InterruptedException{
		if(c==null) {
			c=new MyController( B1C, B2C, B3C, P1N, speedP1, P2N, speedP2, composerNum,speedCom,consumerNum, speedCon);
			
		}
	}
	@Override
	public void run() {
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(com).start();
//		for(int i=0;i<consumerNum;i++) {
//			new Thread(new Consumer(buffer3,buffer4,consumerSpeed)).start();
//		}
		//new Thread(con).start();
	}
	public static void crun(int B1C,int B2C,int B3C,int P1N,int speedP1,int P2N,int speedP2,int composerNum,int speedCom,int consumerNum,int speedCon) {
		if(c==null) {
			c=new MyController( B1C, B2C, B3C, P1N, speedP1, P2N, speedP2, composerNum,speedCom,consumerNum, speedCon);
		}
		c.start();
	}

	public static void cstop() {
		c.p1.mstop();
		c.p2.mstop();
		c.com.mstop();
		c.con.mstop();
	}
	
	public static void cstart() {
		c.p1.mrun();
		c.p2.mrun();
		c.com.mrun();
		c.con.mrun();
		c.run();
	}
	public static void creset() throws InterruptedException {
		c.cstop();
		Thread.sleep(1000*1);
		c.box1.clear();
		c.box2.clear();
		c.box3.clear();
		c.box4.clear();
	    c=null;

	}
}
