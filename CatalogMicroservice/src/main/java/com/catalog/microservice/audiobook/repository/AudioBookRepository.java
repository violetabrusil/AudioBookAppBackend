package com.catalog.microservice.audiobook.repository;

import java.util.ArrayList;
import java.util.List;

import com.catalog.microservice.audiobook.AudioBook;

public class AudioBookRepository {
	
	private List<AudioBook> audioBookRepository;

	public AudioBookRepository(List<AudioBook> audioBookRepository) {
		super();
		this.audioBookRepository = audioBookRepository;
	}

	public AudioBookRepository() {
		super();
		audioBookRepository = new ArrayList<AudioBook>();
		
	}

	public List<AudioBook> getAudioBookRepository() {
		return audioBookRepository;
	}

	public void setAudioBookRepository(List<AudioBook> audioBookRepository) {
		this.audioBookRepository = audioBookRepository;
	}

	@Override
	public String toString() {
		
		String result = "";
		
		for (AudioBook audioBook : audioBookRepository) {
			result += audioBook.toString() + "\n";	
		}
		return result;
	}
	
	
	
	

}
