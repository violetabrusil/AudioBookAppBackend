package com.catalog.microservice.audiobook.factory;

import com.catalog.microservice.audiobook.AudioBook;

public class AudioBookFactory {
	
	public AudioBook createBook(Integer idAudioBook, String titleAudioBook, String author, String sipnosis, String urlImage,
			String urlAudio, String gender) {
		
		AudioBook newAudioBook = null;
		newAudioBook = new AudioBook(idAudioBook, titleAudioBook, author, sipnosis, urlImage, urlAudio, gender);
		
		return newAudioBook;
				
	}

}
