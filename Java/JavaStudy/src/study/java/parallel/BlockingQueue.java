package study.java.parallel;

import java.util.concurrent.ArrayBlockingQueue;

public class BlockingQueue {
	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<Integer> bq = new ArrayBlockingQueue(10);
		
		bq.put(10);
		bq.put(11);
		bq.put(12);
		bq.put(13);
		bq.put(14);
		bq.put(15);
		bq.put(16);
		bq.put(17);
		bq.put(18);
		bq.put(19);
		//bq.put(20);	//¿¡·¯
		System.out.println(bq.take());

		bq.stream().forEach(a -> {System.out.println(a);});
	}
}
