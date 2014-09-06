package com.example.makexml.domain;




public class SmsInfo {
	private long date;
	private int  type;
	private String body;
	private String adress;
	private int id ;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SmsInfo() {
		super();

	}
	
	public SmsInfo(long date, int type, String body, String adress,int id) {
		super();
		this.date = date;
		this.type = type;
		this.body = body;
		this.adress = adress;
		this.id = id;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

		
}
