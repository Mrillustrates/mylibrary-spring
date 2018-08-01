package com.chriscoding.mylibraryspring.controllers;

import com.chriscoding.mylibraryspring.models.Librarian;
import com.chriscoding.mylibraryspring.models.dao.BookDao;
import com.chriscoding.mylibraryspring.models.dao.LibrarianDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;

public class AbstractController {

    @Autowired
    protected LibrarianDao librarianDao;

    @Autowired
    protected BookDao bookDao;


    public static final String userSessionKey = "user_id";

    protected Librarian getUserFromSession(HttpSession session) {
        //request.getSession to retrieve active session
        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : librarianDao.findByUid(userId);
    }

    protected void setUserInSession(HttpSession session, Librarian librarian) {
        session.setAttribute(userSessionKey, librarian.getUid());

    }
}
