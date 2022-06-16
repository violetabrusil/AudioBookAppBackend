package com.catalog.microservice.utils.finder.impl;

import java.util.ArrayList;
import java.util.List;

import com.catalog.microservice.playlist.PlayList;
import com.catalog.microservice.playlist.factory.PlayListFactory;
import com.catalog.microservice.utils.SearchType;
import com.catalog.microservice.utils.finder.Finder;

public class PlayListNameFinder extends Finder<PlayList>  {

	
	public PlayListNameFinder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compare(PlayList o1, PlayList o2) {
		if(o1.getNamePlayList().contains(o2.getNamePlayList())) {
			return 0;
		} else {
			return -1;
		}
	}

	@Override
	public List<PlayList> find(List<PlayList> listToSearch, String wordToFind) {
		PlayList target = PlayListFactory.getInstance().createPlayList();
		target.setNamePlayList(wordToFind);
		List<PlayList> resultList = new ArrayList<PlayList>();
		for (PlayList playList : listToSearch) {
			if(this.compare(playList,target) == 0){
				resultList.add(playList);
			} 
		} return resultList;
	}
	
	

}
