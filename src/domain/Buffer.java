package domain;

import java.util.ArrayList;

public class Buffer {
	private static ArrayList<Integer> list;
	private static int capacity;
	
	public Buffer() {
	}
	public Buffer(int capacity,ArrayList<Integer> box) {
		this.capacity=capacity;
		list=box;
	}
	
	
	public  synchronized void push(int num) {
		System.out.println("生成前有：" +list.size());
		while(capacity==list.size()) {
			System.out.println("满了");
			try {
				this.wait();				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		this.notify();
		list.add(num);
		System.out.println("当前有：" +list.size());
	}
	public  synchronized void pop() {
		System.out.println("消费前有：" +list.size());
		while(0==list.size()) {
			System.out.println("buffer空了");
			try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.notify();
		int popNum = list.remove(0);
		System.out.println("取出了："+1);
		System.out.println("当前有:"+list.size());
		
		
	}

}
