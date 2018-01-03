package com.savchenko.slides.Model;

public class Slide {
	
	private int serialNumber;
	private String img;
	
	public Slide(){
	}
	
	public Slide(int serialNumber, String img){
		this.serialNumber = serialNumber;
		this.img = img;
	}
	
	public int getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(int serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
		
}