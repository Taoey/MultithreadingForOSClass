package domain;

import java.util.ArrayList;

public class Box {
	private static ArrayList<Integer> box1;
	private static ArrayList<Integer> box2;
	private static ArrayList<Integer> box3;
	private static ArrayList<Integer> box4;
	private Box() {
		box1=new ArrayList<>();
		box2=new ArrayList<>();
		box3=new ArrayList<>();
		box4=new ArrayList<>();
	}
	
	

	
	public static  ArrayList<Integer> getBox1() {
		if(null==box1) {
			box1=new ArrayList<>();
		}
		return box1;
	}
	public static  ArrayList<Integer> getBox2() {
		if(null==box2) {
			box2=new ArrayList<>();
		}
		return box2;
	}
	public static  ArrayList<Integer> getBox3() {
		if(null==box3) {
			box3=new ArrayList<>();
		}
		return box3;
	}
	public static  ArrayList<Integer> getBox4() {
		if(null==box4) {
			box4=new ArrayList<>();
		}
		return box4;
	}
	
	public static int getSize1() {
		return box1.size();
	}
	public static int getSize2() {
		return box2.size();
	}
	public static int getSize3() {
		return box3.size();
	}
	public static int getSize4() {
		return box4.size();
	}
	
	
	
}
