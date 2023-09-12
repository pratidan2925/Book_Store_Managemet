package com.example.BookStore.Service;

import java.util.*;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.BookStore.Dao.BookStoreDaoi;
import com.example.BookStore.entity.BookStore;

@Service
public class BookstoreService {
	
@Autowired
private BookStoreDaoi bd;

	public void save(BookStore b) {
	bd.save(b);	
	}
	

public List<BookStore> getallBooks(){
	return  bd.findAll();
}


public BookStore getBookById(int id) {
	return bd.findById(id).get();
}

public void deleteById(int id) {
	bd.deleteById(id);
}


}
