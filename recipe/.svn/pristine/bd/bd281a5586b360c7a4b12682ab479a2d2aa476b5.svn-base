package com.onethefull.recipe.comm.vo;

import java.util.ArrayList;
import java.util.List;

public class MailContext {
	private String fromAddress;
	private String toAddress;
	private List<String> toAddresses;
	private String subject;
	private String message;

	public MailContext() {
	}
	public String getFromAddress() {
		return fromAddress;
	}
	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}
	public String getToAddress() {
		return toAddress;
	}
	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}
	public List<String> getToAddresses() {
		return toAddresses;
	}
	public void setToAddresses(List<String> toAddresses) {
		this.toAddresses = toAddresses;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void addToAddress(String toAddress) {
		if(this.getToAddresses() == null) {
			this.toAddresses = new ArrayList<String>();
		}
		this.toAddresses.add(toAddress);
	}
	public void removeToAddress(String toAddress) {
		if(this.getToAddresses() != null && !this.getToAddresses().isEmpty()) {
			if(this.getToAddresses().contains(toAddress)) {
				this.toAddresses.remove(toAddress);
			}
		}
	}
	public boolean isToAddresses() {
		return (this.getToAddresses() == null || this.getToAddresses().isEmpty()) ? false : true;
	}
}
