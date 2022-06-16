package com.catalog.microservice.playlist;


import java.util.ArrayList;
import java.util.List;

import com.catalog.microservice.audiobook.AudioBook;

public class PlayList {
	
	private String namePlayList;
	private String urlimagePlayList;
	private List<AudioBook> listAudioBook;
	
	
	public PlayList() {
		super();
	}

	public PlayList(String namePlayList, String urlimagePlayList) {
		super();
		this.namePlayList = namePlayList;
		this.urlimagePlayList = urlimagePlayList;
		listAudioBook = new ArrayList<AudioBook>();
		
	}

	public PlayList(String namePlayList, String urlimagePlayList, List<AudioBook> listAudioBook) {
		super();
		this.namePlayList = namePlayList;
		this.urlimagePlayList = urlimagePlayList;
		this.listAudioBook = listAudioBook;
	}
	

	public String getNamePlayList() {
		return namePlayList;
	}

	public void setNamePlayList(String namePlayList) {
		this.namePlayList = namePlayList;
	}

	public String getUrlimagePlayList() {
		return urlimagePlayList;
	}

	public void setUrlimagePlayList(String urlimagePlayList) {
		this.urlimagePlayList = urlimagePlayList;
	}

	public List<AudioBook> getListAudioBook() {
		return listAudioBook;
	}

	public void setListAudioBook(List<AudioBook> listAudioBook) {
		this.listAudioBook = listAudioBook;
	}

	@Override
	public String toString() {
		
		String result = "PlayList [namePlayList=" + namePlayList + ", urlimagePlayList=" + urlimagePlayList+ "]";
	
		for (AudioBook audioBook : listAudioBook) {
			result += audioBook + "\n";
		}
		return result;
	}
	
	
	

}
