package com.pvp.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pvp.spring5webapp.model.Author;
import com.pvp.spring5webapp.model.Book;
import com.pvp.spring5webapp.model.Publisher;
import com.pvp.spring5webapp.repositories.AuthorRepository;
import com.pvp.spring5webapp.repositories.BookRepository;
import com.pvp.spring5webapp.repositories.PublisherRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	/**
	 * Praveen V P 13-06-2018
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		initData();

	}

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	private PublisherRepository publisherRepository;

	public DevBootStrap(BookRepository bookRepository, AuthorRepository authorRepository,
			PublisherRepository publisherRepository) {

		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
		this.publisherRepository = publisherRepository;
	}

	private void initData() {

		Publisher oRealy = new Publisher("oRealy", "ORealy address");
		Publisher willy = new Publisher("Willy", "Willy address");
		publisherRepository.save(willy);
		publisherRepository.save(oRealy);
		
		Author eric = new Author("Eric", "Evans");
		Book book1 = new Book("Domain Driven Design", "isbn1", oRealy);
		eric.getBooks().add(book1);

		authorRepository.save(eric);
		bookRepository.save(book1);
		
		Author john = new Author("John", "David");
		Book book2 = new Book("Book2", "isbn2", willy);
		eric.getBooks().add(book2);

		authorRepository.save(john);
		bookRepository.save(book2);
	}

}
