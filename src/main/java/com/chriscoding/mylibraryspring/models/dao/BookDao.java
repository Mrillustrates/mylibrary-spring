package com.chriscoding.mylibraryspring.models.dao;

import com.chriscoding.mylibraryspring.models.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface BookDao extends CrudRepository<Book, Integer> {

   // List<Book> findbyAuthor(int authorid);

    List<Book> findAll();
    Book findByUid(int uid);
    Book findByAuthor(String author);

    //Book findByTitle(String title);
    //Book findByAuthorId(int id);


}
