package com.catalog.microservice.audiobook;

public class AudioBook {
	
	private Integer idAudioBook;
	private String titleAudioBook;
	private String author;
	private String sipnosis;
	private String urlImage;
	private String urlAudio;
	private String gender;
	
	public AudioBook(Integer idAudioBook, String titleAudioBook, String author, String sipnosis, String urlImage,
			String urlAudio, String gender) {
		super();
		this.idAudioBook = idAudioBook;
		this.titleAudioBook = titleAudioBook;
		this.author = author;
		this.sipnosis = sipnosis;
		this.urlImage = urlImage;
		this.urlAudio = urlAudio;
		this.gender = gender;
	}
	
	
	public AudioBook() {
		super();
	}


	public Integer getIdAudioBook() {
		return idAudioBook;
	}


	public void setIdAudioBook(Integer idAudioBook) {
		this.idAudioBook = idAudioBook;
	}


	public String getTitleAudioBook() {
		return titleAudioBook;
	}
	
	public void setTitleAudioBook(String titleAudioBook) {
		this.titleAudioBook = titleAudioBook;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getSipnosis() {
		return sipnosis;
	}
	
	public void setSipnosis(String sipnosis) {
		this.sipnosis = sipnosis;
	}
	
	public String getUrlImage() {
		return urlImage;
	}
	
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
	
	public String getUrlAudio() {
		return urlAudio;
	}
	
	public void setUrlAudio(String urlAudio) {
		this.urlAudio = urlAudio;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "AudioBook [iidAudioBook=" + idAudioBook + ", titleAudioBook=" + titleAudioBook + ", author=" + author + ", sipnosis="
				+ sipnosis + ", urlImage=" + urlImage + ", urlAudio=" + urlAudio + ", gender=" + gender + "]";
	}

	
	
	
	
	

}
