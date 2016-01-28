package com.intertech.lab1;

import java.util.ArrayList;
import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.intertech.messager.Messenger;



public class Startup {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-components.xml");
		
		int threadCount = 1;
		List<Thread> threads = new ArrayList<>();

		
		for (int i = 0; i < threadCount; i++) {
			Thread thread = new Thread(new Messenger("th"+i));
			threads.add(thread);
		}
		for (Thread thread : threads) {
			thread.start();
		}

	}
}
