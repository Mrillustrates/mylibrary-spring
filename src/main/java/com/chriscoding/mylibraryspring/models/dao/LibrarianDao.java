package com.chriscoding.mylibraryspring.models.dao;

import com.chriscoding.mylibraryspring.models.Librarian;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface LibrarianDao extends CrudRepository <Librarian, Integer> {

    Librarian findByUid(int uid);

    List<Librarian> findAll();

    Librarian findByUsername(String username);
}
