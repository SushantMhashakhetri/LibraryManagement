package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.Entities.Book;
import com.library.services.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	List<Book> getAllBooks(){
	  return this.bookService.getAllBooks();
	}
	
	@PostMapping("/add")
	Book addBook(@RequestBody Book book) {
		return this.bookService.saveBook(book);
	}
	
	@GetMapping("/{bookId}")
	Optional<Book> getBook(@PathVariable Long bookId) {
		return this.bookService.findBook(bookId);
		
	}
	
	@DeleteMapping("/delete/{bookId}")
	ResponseEntity<Void> deleteBook(@PathVariable Long bookId){
		 this.bookService.deleteBook(bookId);
		 return null;
	}
	
	@PostMapping("/{bookId}/borrow/{userId}")
	public ResponseEntity<Book> borrowBook(@PathVariable Long bookId,@PathVariable Long userId){
		Book book = bookService.borrowBook(bookId, userId);
		if (book!=null) {
			return ResponseEntity.ok(book);
		}
//		return ResponseEntity.badRequest().build();
		return ResponseEntity.ofNullable(null);
	}
	
	@PostMapping("/{bookId}/return")
	ResponseEntity<Book> returnBook(@PathVariable Long bookId){
		Book book = bookService.returnBook(bookId);
		if (book !=null) {
			return ResponseEntity.ok(book);
		}
		return ResponseEntity.ofNullable(null);
	}

}
