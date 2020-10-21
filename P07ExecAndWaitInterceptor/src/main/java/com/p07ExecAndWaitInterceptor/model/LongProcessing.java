package com.p07ExecAndWaitInterceptor.model;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

public class LongProcessing extends ActionSupport{
	
	private int pTime;
	private String processingTime;

	public int getpTime() {
		return pTime;
	}

	public void setpTime(int pTime) {
		this.pTime = pTime;
	}
	public String getProcessingTime() {
		return processingTime;
	}

	public void setProcessingTime(String processingTime) {
		this.processingTime = processingTime;
	}
	
	public String execute() {
		//it should be delay few seconds,
	    //unless you have a super powerful computer.
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date startTime = calendar.getTime();
		//Instant startTime = Instant.now();
		for(int i=0; i<1000000;i++) {
			System.out.println("i "+i);
		}
		Calendar calendar1 = Calendar.getInstance();
		Date endTime = calendar1.getTime();
		//Instant endTime = Instant.now();
		long totalTime = endTime.getTime() - startTime.getTime();
		//Duration totalTimes = Duration.between(startTime, endTime);
		//long totalTime = totalTimes.toMillis();
		long diffSeconds = totalTime / 1000 % 60;
		long diffMinutes = totalTime / (60 * 1000) % 60;
		long diffHours = totalTime / (60 * 60 * 1000) % 24;
		long diffDays = totalTime / (24 * 60 * 60 * 1000);
		String etime = (diffHours != 0)?"Time taken: "+ diffHours +" hour "+diffMinutes+" minute "+diffSeconds+" second. "
				:(diffMinutes != 0)?"Time taken: "+diffMinutes+" minute "+diffSeconds+" second. "
				:"Time taken: "+diffSeconds+" second. ";
		setProcessingTime(etime);
			System.out.println(etime);
		return SUCCESS;
	}

}
