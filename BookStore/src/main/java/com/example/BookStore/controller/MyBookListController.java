package com.example.BookStore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.BookStore.Service.MyBookListService;

@Controller
public class MyBookListController {
	@Autowired
	private MyBookListService bookser;
	
	

	@RequestMapping("/deleteMyList/{id}")
	public String deleteMyList(@PathVariable("id") int id) {
		bookser.deleteById(id);
		return "redirect:/my_books";
	}

}
