package test;

import java.util.ArrayList;

import org.junit.Test;

import domain.Box;
import domain.Buffer;
import domain.Consumer;
import domain.Producer;

public class MainTest {
	
	
	@Test
	public void test01() {
		ArrayList<Integer> box=Box.getBox();
		Buffer buffer=new Buffer(10,box);
				
		Consumer c=new Consumer(buffer,1);
		Producer p= new Producer(buffer,10);
		
		new Thread(c).start();
		new Thread(p).start();


	}

}
