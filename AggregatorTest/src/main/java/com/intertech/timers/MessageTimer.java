package com.intertech.timers;

import java.util.Date;
import java.util.List;
import com.intertech.objects.Job;


public class MessageTimer {
	
	public void printTimeS(List<Job> keys){
		if (!keys.isEmpty()) {	
			Job fjob = keys.get(0);
			Date now = new Date();
			Date start = fjob.getDte();
			long t = now.getTime() - start.getTime();
		
			System.out.println(String.format("Time : %5d ms  List size : %-5d  Hash : %-12s By thread : %-4s -FP" , 
					t, 
					keys.size(),
					fjob.hashCode(),
					fjob.getThreadName()));
		}
	}
}
