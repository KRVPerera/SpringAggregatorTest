package com.intertech.messager;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import com.intertech.objects.Job;

public class Messenger implements Runnable {

	MessageChannel channel;
	private String name;
	private int sequenceSize = 1000;
	private int CORRELATION_ID_MAX = 1000;

	public Messenger(String name) {
		this();
		this.name = name;
	}

	@SuppressWarnings({ "resource" })
	private Messenger() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"/META-INF/spring/si-components.xml");
		channel = context.getBean("messageChannel", MessageChannel.class);
	}

	public Messenger(String name, int times) {
		this();
		this.name = name;
	}

	public void run() {
		int correlationId = 0;
		while (true) {

			for (int sequenceNumber = 0; sequenceNumber < sequenceSize; sequenceNumber++) {
				Job jp = new Job(name);
				Message<Job> message2 = MessageBuilder.withPayload(jp).setSequenceNumber(sequenceNumber)
						.setSequenceSize(sequenceSize).setCorrelationId(correlationId).build();
				channel.send(message2);
			}

			try {
				Thread.sleep(100, 0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			correlationId++;
			if (correlationId >= CORRELATION_ID_MAX) {
				correlationId = 0;
			}
		}
	}
}
