package com.savchenko.slides.Model;

public class Presentation {
	
	private int id;
	private String folderName;
	private int numberOfSlides;
	
	public Presentation(){
	}

	public Presentation(int id, String folderName, int numberOfSlides) {
		this.id = id;
		this.folderName = folderName;
		this.numberOfSlides = numberOfSlides;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFolderName() {
		return folderName;
	}

	public void setFolderName(String folderName) {
		this.folderName = folderName;
	}

	public int getNumberOfSlides() {
		return numberOfSlides;
	}

	public void setNumberOfSlides(int numberOfSlides) {
		this.numberOfSlides = numberOfSlides;
	}
	
}
