package com.library.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.Entities.Book;
import com.library.Entities.User;
import com.library.repository.BookRepo;
import com.library.repository.UserRepo;

@Service
public class BookService {
	
	@Autowired
	private BookRepo bookRepo;
	
	@Autowired
	private UserRepo userRepo;
	
    public Book saveBook(Book book) {
    return this.bookRepo.save(book);
    }
    
    public Optional<Book> findBook(Long bookId){
    	return this.bookRepo.findById(bookId);
    }
    
    public List<Book> getAllBooks() {
    	return this.bookRepo.findAll();
    }
    
    public void deleteBook(Long bookId) {
    	
    	this.bookRepo.deleteById(bookId);
    	
    }
    
    public Book borrowBook(Long bookId, Long userId) {
    Book book = findBook(bookId).get();
    User user = userRepo.findById(userId).get();
    if(book!= null && !book.getBorrowed())  {
    	book.setBorrowed(true);
    	book.setBorrowedBy(user);
    	return saveBook(book);
    }
    
    return null;
    
    }
    
    public Book returnBook(Long bookId) {
    	   Book book = findBook(bookId).get();
    	  
    	    if(book!= null && book.getBorrowed())  {
    	    	book.setBorrowed(false);
    	    	book.setBorrowedBy(null);
    	    	return saveBook(book);
    	    }
    	    
    	    return null;
    }
    
    
    

}
