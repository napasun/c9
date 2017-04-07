package study.java.parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class ParallelStreams {
	public static long iterativeSum(long n) {
		List<Integer> stream = new ArrayList<Integer>();
		stream.add(1);
		stream.stream()
			.filter(s -> true)
			.parallel()
			.map( s -> s+1 );
		
		stream.parallelStream();
		
		
        long result = 0;
        for (long i = 0; i <= n; i++) {
            result += i;
        }
        return result;
    }

    public static long sequentialSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).reduce(Long::sum).get();
    }

    public static long parallelSum(long n) {
        return Stream.iterate(1L, i -> i + 1).limit(n).parallel().reduce(Long::sum).get();
    }

    public static long rangedSum(long n) {
        return LongStream.rangeClosed(1, n).reduce(Long::sum).getAsLong();
    }

    public static long parallelRangedSum(long n) {
        return LongStream.rangeClosed(1, n).parallel().reduce(Long::sum).getAsLong();
    }

    

    public static void test(long n) {
        Cal cal= new Cal();
        Cal cal2= new Cal();
        AtomicCal cal3 = new AtomicCal();
        LockCal cal4 = new LockCal();
        SyncCal cal5 = new SyncCal();
        
        LongStream.rangeClosed(1, n).forEach(cal::add);		//순차연산
        LongStream.rangeClosed(1, n).parallel().forEach(cal2::add); //병렬연산
        LongStream.rangeClosed(1, n).parallel().forEach(cal3::add); //병렬연산
        LongStream.rangeClosed(1, n).parallel().forEach(cal4::add); //Lock연산
        LongStream.rangeClosed(1, n).parallel().forEach(cal5::add);
        
        System.out.println("cal: "+ cal.total + " cal2: "+ cal2.total);
        System.out.println("cal3: "+ cal3.total + " cal4: "+ cal4.total);
        System.out.println("cal5: "+ cal5.total);
    }

    public static class SyncCal {
        private long total = 0;	//공유되는 값

        public synchronized void add(long value) {
        	total += value;
        }
    }
    
    public static class LockCal {
    	Lock lock = new ReentrantLock();
        private long total = 0;	//공유되는 값

        public void add(long value) {
        	//Lock lock = new ReentrantLock();
        	lock.lock();
        	total += value;
        	lock.unlock();
        }
    }
    
    public static class Cal {
        private long total = 0;	//공유되는 값

        public void add(long value) {
        	total += value;
        }
    }
    
    public static class AtomicCal {
    	//Atomic[Integer|Boolean|Long....] 여러 스레드에서 공유 카운터를 업데이트 할 때 스레드에 안전한 방식으로 일어나게 해준다.
    	private AtomicLong total = new AtomicLong(0L);
    	
    	public void add(long value) {
    		total.accumulateAndGet(value, Long::sum);
    		//total.addAndGet(value);
    	}
    }
}
