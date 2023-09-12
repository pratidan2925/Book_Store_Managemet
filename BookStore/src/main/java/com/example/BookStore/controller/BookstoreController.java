package com.example.BookStore.controller;

import java.util.List;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.BookStore.Service.BookstoreService;
import com.example.BookStore.Service.MyBookListService;
import com.example.BookStore.entity.BookStore;
import com.example.BookStore.entity.MyBookList;




@Controller
public class BookstoreController {
	
	@Autowired
private	BookstoreService service;
	
	@Autowired
	private MyBookListService mybooklistser;
	
	@GetMapping("/home")
	public String home(){
		return "home";
		
	}

	@GetMapping("/book_register")
	public String bookregister() {
		return "bookregister";
	}
	
	@GetMapping("/avilable_books")
	public ModelAndView getallBooks() {
		List<BookStore> ls = service.getallBooks()	;
		return new ModelAndView("booklist","book",ls) ;
	}


	
	@PostMapping("/save")
	public String addBook(@ModelAttribute BookStore b) {
		service.save(b);
		return "redirect:/avilable_books";
		
	}
	
	@GetMapping("/my_books")
	public String getMyBook(Model model) {
		
		List<MyBookList> list = mybooklistser.getAllMyBooks();
		model.addAttribute("book", list);
		return "mybooks";
		
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		BookStore bb = service.getBookById(id);
		MyBookList mb = new MyBookList(bb.getId(),bb.getName(),bb.getAuthor(),bb.getPrice());
		mybooklistser.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id,Model model) {
		BookStore b=service.getBookById(id);
		model.addAttribute("book",b);
		return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id) {
		service.deleteById(id);
		return "redirect:/available_books";
	}
}
