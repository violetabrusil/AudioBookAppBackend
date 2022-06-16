package com.catalog.microservice.playlist.factory;

import java.util.List;

import com.catalog.microservice.audiobook.AudioBook;
import com.catalog.microservice.playlist.PlayList;

public class PlayListFactory {
	
	/**
	 * Instance of singleton
	 */
	
	private static PlayListFactory instance;
	
	
	
	private PlayListFactory() {
		super();
	}
	
	public static PlayListFactory getInstance() {
		if (instance == null) {
			synchronized (PlayListFactory.class) {
				if (instance == null) {
					instance = new PlayListFactory();
				}
			}
		}
		return instance;
	}


	public PlayList createPlayList(String namePlayList, String urlimagePlayList) {
		
		PlayList newPlayList = null;
		newPlayList = new PlayList(namePlayList, urlimagePlayList);
		
		return newPlayList;
		
	}
	
	public PlayList createPlayList() {
		PlayList newPlayList = null;
		newPlayList = new PlayList();
		
		return newPlayList;
	}

}
