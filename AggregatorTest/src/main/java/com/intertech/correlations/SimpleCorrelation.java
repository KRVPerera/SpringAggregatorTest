package com.intertech.correlations;

import org.springframework.messaging.Message;

public class SimpleCorrelation {
	
	public int groupByCorrelationID(Message message) {
		Object obj = message.getHeaders().get("correlationId");
		return (int)obj;
	  }
}
