package com.catalog.microservice.playlist.manager;

import java.util.List;

import com.catalog.microservice.audiobook.AudioBook;
import com.catalog.microservice.audiobook.manager.AudioBookManager;
import com.catalog.microservice.playlist.PlayList;
import com.catalog.microservice.utils.SearchType;

public class PlayListManager {
	
	private static PlayListManager instance;
	
	private PlayListManager() {
		super();
	}
	
	public static PlayListManager getInstance() {
		if (instance == null) {
			synchronized (PlayListManager.class) {
				if (instance == null) {
					instance = new PlayListManager();
				}
			}
		}
		return instance;
	}
	
	public List<PlayList> editPlayList(List<PlayList> playLists, PlayList oldPlayList, PlayList newPlayList) {
		playLists.remove(oldPlayList);
		playLists.add(newPlayList);
		return playLists;
		
	}

	public void addAudioBookToPlayList(PlayList playList, AudioBook audiobook) {
		List<AudioBook> newList = playList.getListAudioBook();
		newList = AudioBookManager.getInstance().addAudioBook(newList, audiobook);
		playList.setListAudioBook(newList);
	}
	//caso de prueba
	public List<AudioBook> searchAudioBookOnPlayList(PlayList playList, String titleToSearch) {
		List<AudioBook> newList = playList.getListAudioBook();
		newList = AudioBookManager.getInstance().searchAudioBook(newList, titleToSearch, SearchType.SEARCH_PER_TITLE);
		return newList;
	}
	
	public void removeAudioBookToPlayList(PlayList playList, String idAudioBook) {
		List<AudioBook> newList = playList.getListAudioBook();
		newList = AudioBookManager.getInstance().deleteAudioBook(newList, idAudioBook);
		playList.setListAudioBook(newList);
	}

}
