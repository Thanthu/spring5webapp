package com.springboot.spring5webapp.bootstrap;

import java.util.HashSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springboot.spring5webapp.domain.Author;
import com.springboot.spring5webapp.domain.Book;
import com.springboot.spring5webapp.domain.Publisher;
import com.springboot.spring5webapp.repositories.AuthorRepository;
import com.springboot.spring5webapp.repositories.BookRepository;
import com.springboot.spring5webapp.repositories.PublisherRespository;

@Component
public class BootStrapData implements CommandLineRunner {
	
	private final AuthorRepository authorRepository;
	
	private final BookRepository bookRepository;
	
	private final PublisherRespository publisherRespository;

	public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRespository publisherRespository) {
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRespository = publisherRespository;
	}

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Started in Bootstrap");
		
		Publisher publisher = new Publisher("Avengers", "Stark Tower", "New York", "CA", "12345");
		
		Author thanthu = new Author("Thanthu", "Nair");
		Book aboutSpring = new Book("About Spring", "123123");
		thanthu.getBooks().add(aboutSpring);
		aboutSpring.getAuthors().add(thanthu);
		publisher.getBooks().add(aboutSpring);
		
		authorRepository.save(thanthu);
		bookRepository.save(aboutSpring);
		
		Author tonyStark = new Author("Tony", "Stark");
		Book iAmIronMan = new Book("I an Iron Man", "123124");
		tonyStark.getBooks().add(iAmIronMan);
		iAmIronMan.getAuthors().add(tonyStark);
		publisher.getBooks().add(iAmIronMan);
		
		authorRepository.save(tonyStark);
		bookRepository.save(iAmIronMan);
		publisherRespository.save(publisher);
		
		System.out.println("Number of books: " + bookRepository.count());
		System.out.println("Number of publishers: " + publisherRespository.count());
		System.out.println("Number of books for publisher: " + publisher.getBooks().size());
	}
	
	

}
