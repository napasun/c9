package study.java.parallel;

import java.util.concurrent.ForkJoinPool;
import java.util.function.Function;

public class ParallelStreamsHarness {
	public static final ForkJoinPool FORK_JOIN_POOL = new ForkJoinPool();

    public static void main(String[] args) {
    	ParallelStreams.test(10_000_000L);
    	
    	
    	/*speedCheck("for", ParallelStreams::iterativeSum, 10_000_000L);
        System.out.println("");
        speedCheck("순차 스트림", ParallelStreams::sequentialSum, 10_000_000L);
        System.out.println("");
        speedCheck("병렬 스트림", ParallelStreams::parallelSum, 10_000_000L);
        System.out.println("");
        speedCheck("LongStream", ParallelStreams::rangedSum, 10_000_000L);
        System.out.println("");
        speedCheck("LongStream 병렬", ParallelStreams::parallelRangedSum, 10_000_000L);*/
    	
    	
        //System.out.println("ForkJoin sum done in: " + measurePerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000L) + " msecs" );
        //System.out.println("SideEffect sum done in: " + measurePerf(ParallelStreams::sideEffectSum, 10_000_000L) + " msecs" );
        //System.out.println("SideEffect prallel sum done in: " + measurePerf(ParallelStreams::sideEffectParallelSum, 10_000_000L) + " msecs" );
    }

    public static <T, R> void speedCheck(String type, Function<T, R> f, T input) {
        long fastest = Long.MAX_VALUE;
        System.out.print(type + " 속도: ");
        for (int i = 0; i < 5; i++) {
            long start = System.nanoTime();
            R result = f.apply(input);
            long duration = (System.nanoTime() - start) / 1_000_000;
            System.out.print(i + "번째 : " + duration + "ms ");
        }
    }
}
