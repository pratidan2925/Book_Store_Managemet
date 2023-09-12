package com.example.BookStore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.entity.BookStore;
@Repository
public interface BookStoreDaoi extends JpaRepository<BookStore, Integer> {

	

}
