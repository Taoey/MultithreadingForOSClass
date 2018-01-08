package domain;

import java.util.Vector;

public class Buffer {
	private Vector<Integer> list;
	private int capacity;
	private int id;
	
	
	public Buffer() {
	}
	public Buffer(int id,int capacity,Vector<Integer> box) {
		this.id=id;
		this.capacity=capacity;
		list=box;
	}
	
	
	public  synchronized void push(int num) {
		System.out.println(id+"生成前有：" +list.size());
		while(capacity==list.size()) {
			System.out.println(id+"满了");
			try {				
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.notifyAll();
		list.add(num);
		System.out.println(id+"当前有：" +list.size());
	}
	public  synchronized void push2(int num) {
		System.out.println(id+"生成前有：" +list.size());
		while(capacity==list.size()) {
			System.out.println(id+"满了");
			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.notifyAll();
		list.add(num);
		System.out.println(id+"当前有：" +list.size());
	}
	public  synchronized void pop() {
		System.out.println(id+"消费前有：" +list.size());
		while(0==list.size()) {
			System.out.println(id+"buffer空了");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notifyAll();
		int popNum = list.remove(0);
		System.out.println(id+"取出了："+1);
		System.out.println(id+"当前有:"+list.size());
		
		
	}

}
