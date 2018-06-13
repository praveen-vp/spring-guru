package com.pvp.spring5webapp.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.pvp.spring5webapp.model.Author;
import com.pvp.spring5webapp.model.Book;
import com.pvp.spring5webapp.repositories.AuthorRepository;
import com.pvp.spring5webapp.repositories.BookRepository;

@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	/**
	 * Praveen V P
	 * 13-06-2018
	 */
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {

		initData();
		
	}

	private BookRepository bookRepository;
	private AuthorRepository authorRepository;
	
	public DevBootStrap(BookRepository bookRepository, AuthorRepository authorRepository) {

		this.bookRepository = bookRepository;
		this.authorRepository = authorRepository;
	}


	private void initData() {
		
		Author eric = new Author("Eric", "Evans");
		Book book1 = new Book("Domain Driven Design", "isbn1", "oRealy");
		eric.getBooks().add(book1);
		
		authorRepository.save(eric);
		bookRepository.save(book1);
		

		Author john = new Author("John", "David");
		Book book2 = new Book("Book2", "isbn2", "willey");
		eric.getBooks().add(book2);
		
		authorRepository.save(john);
		bookRepository.save(book2);
	}
	
}
