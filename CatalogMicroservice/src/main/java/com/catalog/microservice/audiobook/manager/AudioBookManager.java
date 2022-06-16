package com.catalog.microservice.audiobook.manager;

import java.util.List;

import com.catalog.microservice.audiobook.AudioBook;
import com.catalog.microservice.playlist.manager.PlayListManager;
import com.catalog.microservice.utils.SearchType;
import com.catalog.microservice.utils.finder.impl.AuthorFinder;
import com.catalog.microservice.utils.finder.impl.GenderFinder;
import com.catalog.microservice.utils.finder.impl.IdFinder;
import com.catalog.microservice.utils.finder.impl.TitleFinder;

public class AudioBookManager {
	
private static AudioBookManager instance;
	
	private AudioBookManager() {
		super();
	}
	
	public static AudioBookManager getInstance() {
		if (instance == null) {
			synchronized (AudioBookManager.class) {
				if (instance == null) {
					instance = new AudioBookManager();
				}
			}
		}
		return instance;
	}
	
	public List<AudioBook> addAudioBook(List<AudioBook> audioBookList, AudioBook audioBook) {
		List<AudioBook> resultList = searchAudioBook(audioBookList, String.valueOf(audioBook.getTitleAudioBook()), SearchType.SEARCH_PER_TITLE);
		if(resultList.size() == 0) {
			audioBookList.add(audioBook);
			System.out.println("Audiolibro agregado");
		}else {
			System.out.println("Ya existe el audiolibro");
		}
		return audioBookList;	 
	}
	
	public List<AudioBook> editAudioBook(List<AudioBook> audioBookList, AudioBook oldAudioBook , AudioBook newAudioBook) {
		audioBookList.remove(oldAudioBook);
		audioBookList.add(newAudioBook);
		return audioBookList;
	}
	
	public List<AudioBook> deleteAudioBook(List<AudioBook> audioBookList, String idAudioBook) {
		List<AudioBook> resultList = searchAudioBook(audioBookList, idAudioBook, SearchType.SEARCH_BY_ID);
		if(resultList.size() > 0) {
			audioBookList.remove(resultList.get(0));
			System.out.println("Audiolibro eliminado");
		}else {
			System.out.println("No se encontro el audiolibro");
		}
		
		return audioBookList;	
	}
	
	public List<AudioBook> searchAudioBook(List<AudioBook> audioBookList, String wordToSearch, SearchType searchType) {
		
		switch (searchType) {
		case SEARCH_PER_AUTHOR:
			
			AuthorFinder authorFinder = new AuthorFinder();
			return authorFinder.find(audioBookList, wordToSearch);
			
		case SEARCH_PER_TITLE:
			
			TitleFinder titleFinder = new TitleFinder();
			return titleFinder.find(audioBookList, wordToSearch);
		
		case SEARCH_PER_GENDER:
			
			GenderFinder genderFinder = new GenderFinder();
			return genderFinder.find(audioBookList, wordToSearch);
			
		case SEARCH_BY_ID:
			
			IdFinder idFinder = new IdFinder();
			return idFinder.find(audioBookList, wordToSearch);

		default:
			return null;
		}
		
	}
	

}
