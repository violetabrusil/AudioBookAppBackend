package com.catalog.microservice.library;

import java.util.ArrayList;
import java.util.List;

import com.catalog.microservice.audiobook.AudioBook;
import com.catalog.microservice.playlist.PlayList;

public class Library {
	
	private Integer userId;
	private List<PlayList> playList;
	
	
	public Library() {
		super();
	}
	

	public Library(Integer userId) {
		super();
		this.userId = userId;
		this.playList = new ArrayList<PlayList>();
	}

	public Library(Integer userId, List<PlayList> playList) {
		super();
		this.userId = userId;
		this.playList = playList;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public List<PlayList> getPlayList() {
		return playList;
	}

	public void setPlayList(List<PlayList> playList) {
		this.playList = playList;
	}


	@Override
	public String toString() {
		return "Library [userId=" + userId + ", \nplayList=" + playList + "]";
	}

	
	

}
