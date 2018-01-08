package domain;

import java.util.Vector;

public class Buffer {
	private Vector<Integer> list;
	private int index;
	private int capacity;
	private int id;
	
	
	public Buffer() {
	}
	public Buffer(int id,int capacity,Vector<Integer> box) {
		this.id=id;
		this.capacity=capacity;
		list=box;
		index=0;
	}
	
	
	public void push(int num) {
		list.add(num);
		index+=1;
	}

	public void pop() {
		if(list!=null&&list.size()>0) {
			int popNum = list.remove(0);
			index-=1;
		}
		
	}
	
	
	public Vector<Integer> getList() {
		return list;
	}
	public void setList(Vector<Integer> list) {
		this.list = list;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}

}
