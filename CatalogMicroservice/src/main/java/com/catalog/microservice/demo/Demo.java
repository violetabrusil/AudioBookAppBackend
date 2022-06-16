package com.catalog.microservice.demo;

import java.util.ArrayList;
import java.util.List;

import com.catalog.microservice.audiobook.AudioBook;
import com.catalog.microservice.audiobook.manager.AudioBookManager;
import com.catalog.microservice.audiobook.repository.AudioBookRepository;
import com.catalog.microservice.library.Library;
import com.catalog.microservice.library.manager.LibraryManager;
import com.catalog.microservice.playlist.PlayList;
import com.catalog.microservice.playlist.factory.PlayListFactory;
import com.catalog.microservice.playlist.manager.PlayListManager;
import com.catalog.microservice.utils.SearchType;

public class Demo {

	public static void main(String[] args) {

		AudioBook audiobook1 = new AudioBook(1, "Cien años de soledad", "Gabriel Garcia Marquez",
				"Es considerada una obra maestra de la literatura hispanoamericana y universal, así como una de las obras más traducidas y leídas en español",
				null, null, "Novela");
		AudioBook audiobook2 = new AudioBook(2, "Violeta", "Isabel Allende",
				"La épica y emocionante historia de una mujer cuya vida abarca los momentos históricos más relevantes del siglo XX",
				null, null, "Ficción");
		AudioBook audiobook3 = new AudioBook(3, "La vida en 5 minutos ", "Julio Bevione",
				"Con este libro, Bevione resume sus artículos más comentados y nos invita a dedicar cinco minutos para volver a nosotros, a detenernos y repensar la vida de otra manera, a conectarnos con lo que sucede en el plano invisible de las emociones y las sensaciones",
				null, null, "Auto Ayuda");
		AudioBook audiobook5 = new AudioBook(4, "Rayuela", "Julio Cortázar",
				"La historia pone en juego la subjetividad del lector y tiene múltiples finales. A esta obra suele llamársela «antinovela», aunque el mismo Cortázar prefería denominarla «contranovela».",
				null, null, "Novela");
		AudioBook audiobook6 = new AudioBook(4, "Rayuela", "Julio Cortázar",
				"La historia pone en juego la subjetividad del lector y tiene múltiples finales. A esta obra suele llamársela «antinovela», aunque el mismo Cortázar prefería denominarla «contranovela».",
				null, null, "Novela");

		AudioBookRepository repository = new AudioBookRepository();

		List<AudioBook> audioBookList = new ArrayList<AudioBook>();
		List<PlayList> lisPlayList = new ArrayList<PlayList>();

		audioBookList = AudioBookManager.getInstance().addAudioBook(repository.getAudioBookRepository(), audiobook1);
		repository.setAudioBookRepository(audioBookList);

		audioBookList = AudioBookManager.getInstance().addAudioBook(repository.getAudioBookRepository(), audiobook2);
		repository.setAudioBookRepository(audioBookList);

		audioBookList = AudioBookManager.getInstance().addAudioBook(repository.getAudioBookRepository(), audiobook3);
		repository.setAudioBookRepository(audioBookList);

		audioBookList = AudioBookManager.getInstance().addAudioBook(repository.getAudioBookRepository(), audiobook5);
		repository.setAudioBookRepository(audioBookList);

		audioBookList = AudioBookManager.getInstance().addAudioBook(repository.getAudioBookRepository(), audiobook6);
		repository.setAudioBookRepository(audioBookList);
		System.out.printf("Repositorio\n" + repository.toString());

		// EditAudioBook

		AudioBook audiobook4 = new AudioBook();
		audiobook4 = audiobook3;
		audiobook4.setTitleAudioBook("La vida en cinco minutos");
		audiobook4.setGender("Ayuda");

		System.out.printf("Audiolibro\n" + audiobook3.toString());

		audioBookList = AudioBookManager.getInstance().editAudioBook(audioBookList, audiobook3, audiobook4);
		repository.setAudioBookRepository(audioBookList);

		System.out.printf("\nRepositorio Actualizado\n" + repository.toString());

		// Delete

		audioBookList = AudioBookManager.getInstance().deleteAudioBook(audioBookList, "2");
		repository.setAudioBookRepository(audioBookList);
		System.out.printf("\nRepositorio despues de eliminar\n" + repository.toString());

		// SearchByAuthor

		audioBookList = AudioBookManager.getInstance().searchAudioBook(repository.getAudioBookRepository(), "Jul",
				SearchType.SEARCH_PER_AUTHOR);
		System.out.printf("\nBusqueda por autor\n" + audioBookList.toString());

		// SearchByTitle

		audioBookList = AudioBookManager.getInstance().searchAudioBook(repository.getAudioBookRepository(), "Rayuela",
				SearchType.SEARCH_PER_TITLE);
		System.out.printf("\nBusqueda por titulo\n" + audioBookList.toString());

		// SearchByGender

		audioBookList = AudioBookManager.getInstance().searchAudioBook(repository.getAudioBookRepository(), "Novela",
				SearchType.SEARCH_PER_GENDER);
		System.out.printf("\nBusqueda por genero\n" + audioBookList.toString());

		// CreateLibrary
		Library library = LibraryManager.getInstance().createLibrary(1);

		// Playlist

		PlayList playlist = PlayListFactory.getInstance().createPlayList("Favoritos\n", null);
		PlayListManager.getInstance().addAudioBookToPlayList(playlist, audiobook4);
		PlayListManager.getInstance().addAudioBookToPlayList(playlist, audiobook5);
		System.out.printf("\nListas de reproduccion\n" + playlist.toString());

		// Playlist

		PlayList playlist1 = PlayListFactory.getInstance().createPlayList("Novelas\n", null);
		PlayListManager.getInstance().addAudioBookToPlayList(playlist1, audiobook1);
		System.out.printf("\nListas de reproduccion dos\n" + playlist1.toString());

		// SearchAudioBookInPlayList
		audioBookList = PlayListManager.getInstance().searchAudioBookOnPlayList(playlist, "Rayuela");
		System.out.printf("\nResultado Busqueda\n" + audioBookList.toString());

		// AddPlayListToLibrary
		LibraryManager.getInstance().addPlaylistToLibrary(library, playlist);
		LibraryManager.getInstance().addPlaylistToLibrary(library, playlist1);
		System.out.printf("\nTu Biblioteca\n" + library.toString());

		System.out.println("termino");
		// DeleteAudioBookFromPlayList
		PlayListManager.getInstance().removeAudioBookToPlayList(playlist, "10");
		System.out.printf("\nListas de reproduccion\n" + playlist.toString());

		// SearchPlayListInLibrary
		lisPlayList = LibraryManager.getInstance().searchPlayListOnLibrary(library, "Puequi");
		System.out.printf("\nResultado busqueda de listas de reproduccion\n" + lisPlayList.toString());

		// DeletePlayListFromLibrary
		LibraryManager.getInstance().deletePlayListToLibrary(library, "Puequi");
		System.out.println("Biblioteca despues de eliminar lista de reproduccion" + library.toString());

		// EditPlayList
		PlayList playList2 = new PlayList();
		playList2 = playlist1;
		playList2.setNamePlayList("Novelas y  Ficcion");

		lisPlayList = PlayListManager.getInstance().editPlayList(lisPlayList, playlist1, playList2);
		library.setPlayList(lisPlayList);
		System.out.printf("\nLista de reproduccion actualizada\n" + library.toString());

		// SearchByAuthor

		audioBookList = AudioBookManager.getInstance().searchAudioBook(repository.getAudioBookRepository(), "Andres",SearchType.SEARCH_PER_AUTHOR);
		System.out.printf("\nBusqueda por autor\n" + audioBookList.toString());

		// SearchByTitle

		audioBookList = AudioBookManager.getInstance().searchAudioBook(repository.getAudioBookRepository(), "Camino de sabios",SearchType.SEARCH_PER_TITLE);
		System.out.printf("\nBusqueda por titulo\n" + audioBookList.toString());

		// SearchByGender

		audioBookList = AudioBookManager.getInstance().searchAudioBook(repository.getAudioBookRepository(), "Comedia",SearchType.SEARCH_PER_GENDER);
		System.out.printf("\nBusqueda por genero\n" + audioBookList.toString());

		// Agregar audiolibro playlist caada vez que aguegue busque si ya existe en caso
		// de que si, no puede volver a insertar

	}

}
