package domain;

import java.util.ArrayList;

public class Box {
	private static ArrayList<Integer> box1;
	private static ArrayList<Integer> box2;
	private static ArrayList<Integer> box3;
	private Box() {
		box1=new ArrayList<>();
		box2=new ArrayList<>();
		box3=new ArrayList<>();
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
	
}
