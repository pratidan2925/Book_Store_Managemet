package com.example.BookStore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.BookStore.entity.MyBookList;
@Repository
public interface MyBookListDao extends JpaRepository<MyBookList,Integer>{

}
