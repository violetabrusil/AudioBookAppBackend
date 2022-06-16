package com.catalog.microservice.utils.finder.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalog.microservice.audiobook.AudioBook;
import com.catalog.microservice.utils.finder.Finder;

public class IdFinder extends Finder<AudioBook>{
	

	public IdFinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(AudioBook o1, AudioBook o2) {
		if(o1.getIdAudioBook().equals(o2.getIdAudioBook())) {
			return 0;
		}
		else{
			return -1;
		}
	}

	@Override
	public List<AudioBook> find(List<AudioBook> listToSearch, String wordToFind) {
		List<AudioBook> resultList = new ArrayList<AudioBook>();
		AudioBook temp = new AudioBook();
		temp.setIdAudioBook(Integer.parseInt(wordToFind));
		for (AudioBook audioBook : listToSearch) {
			
			if(this.compare(audioBook, temp) == 0) {
				resultList.add(audioBook);
			}
			
		}
		return resultList;
	}
	
	

}
