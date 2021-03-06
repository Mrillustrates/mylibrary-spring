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


    //Allows librarian to enter new book
    @RequestMapping(value = "newbook", method = RequestMethod.GET)
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



        /*if(title.contains(" ")){
           title=  title.replace(" ", "-");
           Book newEntry = new Book(title, description, author, isbn, pubdate, editor);
           bookDao.save(newEntry);


        }
        else{
            Book newEntry = new Book(title, description, author, isbn, pubdate, editor);
            bookDao.save(newEntry);

        }
        */
        Book newEntry = new Book(title, description, author, isbn, pubdate, editor);

        bookDao.save(newEntry);
        //int id = newEntry.getUid();


        return ("redirect:/book/"+ title );


       }

       //Find book by title name
   @RequestMapping(value = "/{title}", method = RequestMethod.GET)
    public String viewBook(@PathVariable String title, Model model) {


            Book name = bookDao.findByTitle(title);
            //int id = name.getUid();

            model.addAttribute("book", name);


      //  }
          


        return "/book/newbook/bookinfo";

    }

}