package com.chriscoding.mylibraryspring.controllers;

import com.chriscoding.mylibraryspring.models.AbstractEntity;
import com.chriscoding.mylibraryspring.models.Book;
import com.chriscoding.mylibraryspring.models.Librarian;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
@RequestMapping(value= "book")
public class BookController extends AbstractController {


    @RequestMapping(value = "newbook", method = RequestMethod.GET)
    //This code creates a model to control the view of the template . attributeName and attribValue you want to display
    public String bookForm() {
        return "book/newbook/bookform";
    }

    @RequestMapping(value = "newbook", method = RequestMethod.POST)
    public String newBook(HttpServletRequest request, Model model) {

        String isbn = request.getParameter("isbn");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String description = request.getParameter("description");
        Integer pubdate = Integer.valueOf(request.getParameter("pubdate"));
        Librarian editor = getUserFromSession(request.getSession());


        Book newEntry = new Book(title, description, author, isbn, pubdate, editor);
        bookDao.save(newEntry);
        int id = newEntry.getUid();


        return "book/newbook/bookinfo";


    }

   @RequestMapping(value = "/{username}/{uid}", method = RequestMethod.GET)
    public String viewBook(@PathVariable String username, @PathVariable int uid, Model model) {

        //Librarian search = librarianDao.findByUsername(username);

        Book entry = bookDao.findByUid(uid);
        int bookId = entry.getUid();

        if(bookId >= 1){
            model.addAttribute("book", entry);
        }



        return "/book/newbook/bookinfo";

    }
    /*(@RequestMapping(value = "/{author}", method = RequestMethod.GET)
    public String findAuthor(@PathVariable String author, Model model) {
        Book writer = bookDao.findByAuthor(author);
        List<Book> books =


    }*/
}