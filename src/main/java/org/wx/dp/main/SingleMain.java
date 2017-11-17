package org.wx.dp.main;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.wx.dp.SBSingleDog;

public class SingleMain {
	private static boolean flag = false;
	public static void main(String[] args) throws InterruptedException {
		Set<String> instanceSet = new HashSet<>();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		for(int i = 0 ; i <=100 ; i++) {
			executorService.execute(
					() -> {
						while(true) {
							if(flag) {
								SBSingleDog instance = SBSingleDog.getInstance();
								instanceSet.add(instance.toString());
								break;
							}
						}
					}
			);
		}
		Thread.sleep(1000);
		flag = true;
		Thread.sleep(1000);
		
		instanceSet.stream().forEach(System.out::println);
		
		executorService.shutdown();
	}
}
