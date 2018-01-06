package com.savchenko.slides.Model;

public class Slide {
	
	private int id;
	private String img;
	private int nextId;
	
	public Slide(){
	}
	
	public Slide(int id, String img, int nextId){
		this.id = id;
		this.img = img;
		this.nextId = nextId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public int getNextId() {
		return nextId;
	}

	public void setNextId(int nextId) {
		this.nextId = nextId;
	}
	
}
