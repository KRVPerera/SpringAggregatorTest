package com.intertech.releasers;

import java.util.Date;
import java.util.List;

import org.springframework.messaging.Message;

import com.intertech.objects.Job;

public class SimpleReleaseStrategy {
	private Integer maxValue;

	public SimpleReleaseStrategy() {
	}

	public SimpleReleaseStrategy(int maxValue) {
		this.maxValue = maxValue;
	}

	public boolean canReleaseM(List<Message<Job>> numbers) {

		//System.out.println("Release strategy fired Size : " + numbers.size());

		if (numbers.size() >= maxValue) {
			Job fjob = numbers.get(0).getPayload();
			Date now = new Date();
			Date start = fjob.getDte();
			long t = now.getTime() - start.getTime();
			
			System.out.println(String.format("Time : %5d ms  List size : %-5d  Hash : %-12s By thread : %-4s -RS" , 
					t, 
					numbers.size(),
					fjob.hashCode(),
					fjob.getThreadName()));
			
			System.out.println("-------------- Printing message details -------------------- ");
			for (Message<Job> message : numbers) {
				int sequenceNumber = (int) message.getHeaders().get("sequenceNumber");
				int sequenceSize = (int) message.getHeaders().get("sequenceSize");
				int correlationId = (int) message.getHeaders().get("correlationId");
				
				System.out.println(String.format("SN : %-3d  SS : %-3d  CID : %-3d -RS " ,sequenceNumber, sequenceSize, correlationId));

			}
			System.out.println("");
			return true;
		}
		return false;
	}
	
	public boolean canReleaseN(List<Message<Job>> numbers) {

		//System.out.println("Release strategy fired Size : " + numbers.size());

		if (numbers.size() >= maxValue) {
			Job fjob = numbers.get(0).getPayload();
			Date now = new Date();
			Date start = fjob.getDte();
			long t = now.getTime() - start.getTime();
			
			System.out.println(String.format("Time : %5d ms  List size : %-5d  Hash : %-12s By thread : %-4s -RS" , 
					t, 
					numbers.size(),
					fjob.hashCode(),
					fjob.getThreadName()));
			
		/*	System.out.println("-------------- Printing message details -------------------- ");
			for (Message<Job> message : numbers) {
				int sequenceNumber = (int) message.getHeaders().get("sequenceNumber");
				int sequenceSize = (int) message.getHeaders().get("sequenceSize");
				int correlationId = (int) message.getHeaders().get("correlationId");
				
				System.out.println(String.format("SN : %-3d  SS : %-3d  CID : %-3d -RS " ,sequenceNumber, sequenceSize, correlationId));

			}
			System.out.println("");*/
			return true;
		}
		return false;
	}
}
