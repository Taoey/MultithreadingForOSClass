package domain;

import java.util.Vector;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Buffer {
	private Vector<Integer> list;
	private int capacity;
	private int id;
	
	private Lock lock = new ReentrantLock();
	private Condition condition_pro = lock.newCondition();
	private Condition condition_con = lock.newCondition();
	
	public Buffer() {
	}
	public Buffer(int id,int capacity,Vector<Integer> box) {
		this.id=id;
		this.capacity=capacity;
		list=box;
		
	}
	
	
	public void push(int num) {
        lock.lock();
        try{
            //1)循环判断
           System.out.println(id+"生成前有：" +list.size());
           int size=list.size();
           while(capacity==size) {
               //如果为真，放弃生产者的资格
            try {
            	System.out.println(id+"满了");
			    condition_pro.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} //会抛出异常
            
           }
           list.add(num);
           System.out.println(id+"当前有：" +list.size());
           //2)使用消费condition唤醒进程
           condition_con.signal(); //生产者生产完毕后，唤醒消费者的进程（不再是signalAll)
        }
        finally{
            lock.unlock();
        }
	}

	public  void pop() {
        lock.lock();
        try
        {
           //1)循环判断
           System.out.println(id+"消费前有：" +list.size());
           while(0==list.size()) {
			try {
				System.out.println(id+"buffer空了");
				condition_con.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
           }
           //2)使用生产者condition唤醒进程  
           condition_pro.signal(); //消费者消费完毕后，唤醒生产者的进程
           int popNum = list.remove(0);           
   		   System.out.println(id+"取出了："+1);
   		   System.out.println(id+"当前有:"+list.size());
        }
        finally{
            lock.unlock();
        }
	}

}
