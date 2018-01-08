package domain;

import java.util.Vector;


public class Box {
	private static Vector<Integer> box1;
	private static Vector<Integer> box2;
	private static Vector<Integer> box3;
	private static Vector<Integer> box4;
	private static int blockNum;
	private Box() {
		box1=new Vector<>();
		box2=new Vector<>();
		box3=new Vector<>();
		box4=new Vector<>();
		blockNum=0;
	}
	
	

	
	public static  Vector<Integer> getBox1() {
		if(null==box1) {
			box1=new Vector<>();
		}
		return box1;
	}
	public static  Vector<Integer> getBox2() {
		if(null==box2) {
			box2=new Vector<>();
		}
		return box2;
	}
	public static  Vector<Integer> getBox3() {
		if(null==box3) {
			box3=new Vector<>();
		}
		return box3;
	}
	public static  Vector<Integer> getBox4() {
		if(null==box4) {
			box4=new Vector<>();
		}
		return box4;
	}
	
	public static int getSize1() {
		if(box1!=null) {
			return box1.size();
		}
		else {
			return -1;
		}
		
	}
	public static int getSize2() {
		if(box2!=null) {
			return box2.size();
		}
		else {
			return -1;
		}
	}
	public static int getSize3() {
		if(box3!=null) {
			return box3.size();
		}
		else {
			return -1;
		}
	}
	public static int getSize4() {
		if(box4!=null) {
			return box4.size();
		}
		else {
			return -1;
		}
	}
	
	public static void addBlockNum() {
		blockNum=blockNum+1;
	}
	public static void subBlockNum() {
		blockNum=blockNum-1;
	}
	public static int getBlock() {
		return blockNum;
	}
	
	
	
}