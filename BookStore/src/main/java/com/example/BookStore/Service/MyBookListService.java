package com.example.BookStore.Service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.Dao.MyBookListDao;

import com.example.BookStore.entity.MyBookList;

@Service
public class MyBookListService {
	
	@Autowired
	private MyBookListDao md;

	public void saveMyBooks(MyBookList bl) {
		md.save(bl);
	}

	public List<MyBookList> getAllMyBooks() {
		return md.findAll();
	}




public void deleteById(int id) {
	md.deleteById(id);
	
}



}

