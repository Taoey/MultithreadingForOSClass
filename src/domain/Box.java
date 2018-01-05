package domain;

import java.util.ArrayList;

public class Box {
	private static ArrayList<Integer> box;
	
	private Box() {
		box=new ArrayList<>();
	}
	
	

	
	public static  ArrayList<Integer> getBox() {
		if(null==box) {
			box=new ArrayList<>();
		}
		return box;
	}
	
}
