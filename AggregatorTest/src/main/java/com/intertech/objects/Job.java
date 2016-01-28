package com.intertech.objects;

import java.util.Date;

public class Job {
	private Date dte;
	private String threadName;
	
	public final Date getDte() {
		return dte;
	}

	String details;
	
	public Job(){
		this.dte = new Date();
	}
	
	public Job(String threadName){
		this.dte = new Date();
		this.threadName = threadName;
	}

	public final String getThreadName() {
		return threadName;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("Created on : " + dte.toString());
		sb.append(" Created by : " + threadName);
		sb.append(" Hash : " + this.hashCode());
		return sb.toString();		
	}
}
