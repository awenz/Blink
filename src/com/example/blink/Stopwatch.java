package com.example.blink;

public class Stopwatch {
	private long start = 0;
	private long stop = 0;
	private boolean running = false;
	
	public void start() {
		this.start = System.currentTimeMillis();
		this.running = true;
	}
	
	public void stop() {
		this.stop = System.currentTimeMillis();
		this.running = false;
	}
	
	public long getElapsedTime() {
		long elapsed;
		if(running)
			elapsed = System.currentTimeMillis() - start;
		else
			elapsed = stop -start;
		return elapsed;
	}
}
