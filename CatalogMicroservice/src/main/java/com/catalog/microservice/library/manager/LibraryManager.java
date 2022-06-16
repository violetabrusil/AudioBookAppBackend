package com.catalog.microservice.library.manager;

import java.util.List;

import com.catalog.microservice.audiobook.AudioBook;
import com.catalog.microservice.audiobook.manager.AudioBookManager;
import com.catalog.microservice.library.Library;
import com.catalog.microservice.playlist.PlayList;
import com.catalog.microservice.utils.SearchType;
import com.catalog.microservice.utils.finder.impl.PlayListNameFinder;

public class LibraryManager {
	
	private static LibraryManager instance;
	
	private LibraryManager() {
		super();
	}
	
	public static LibraryManager getInstance() {
		if (instance == null) {
			synchronized (LibraryManager.class) {
				if (instance == null) {
					instance = new LibraryManager();
				}
			}
		}
		return instance;
	}
	
	public Library createLibrary(Integer userId) {
		if(userId != 0) {
			
			Library newLibrary = new Library(userId);
			
			System.out.println("BIBLIOTECA");
			return newLibrary;
			
		}
		return null;
		
	}
	
	public void addPlaylistToLibrary(Library library, PlayList playList) {
		List<PlayList> newList = library.getPlayList();
		newList.add(playList);
		library.setPlayList(newList);
	}
	
	public List<PlayList> searchPlayListOnLibrary(Library library, String nameToSearch ) {
		List<PlayList> newList = library.getPlayList();
		PlayListNameFinder playListNameFinder = new PlayListNameFinder();
		return playListNameFinder.find(newList, nameToSearch);
		
	}
	
	public void deletePlayListToLibrary(Library library, String namePlayList) {
		List<PlayList> playLists = library.getPlayList();
		List<PlayList> resultList = searchPlayListOnLibrary(library, namePlayList);
		if (resultList.size() > 0) {
			playLists.remove(resultList.get(0));
			System.out.println("Lista de reproduccion eliminada");
		} else {
			System.out.println("No se encontro la lista de reproduccion");
			
		}
	}
	
	

}
