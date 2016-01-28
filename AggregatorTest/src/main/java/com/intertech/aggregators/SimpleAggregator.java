package com.intertech.aggregators;

import java.util.List;

public class SimpleAggregator {
	public Long add(List<Long> results) {
	    long total = 0l;
	    for (long partialResult: results) {
	      total += partialResult;
	    }
	    return total;
	  }
}
