package multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Test4 {
/*
 * https://segmentfault.com/a/1190000006049612
 */
	int count = 0;

	void increment() {
	    count = count + 1;
	}
	
	void test(){
		ExecutorService executor = Executors.newFixedThreadPool(2);

		IntStream.range(0, 10000)
		    .forEach(i -> executor.submit(this::increment));

//		stop(executor);

		System.out.println(count);  // 9965
	}
	
	public static void main(String[] args) {
		
	}

}
