package com.chriscoding.mylibraryspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


    @Controller
    @RequestMapping(value="book")
    public class CatalogController extends AbstractController {

        //show all books
        @RequestMapping(value = "catalog")
        public String blogIndex(Model model) {
            model.addAttribute("books", bookDao.findAll());

            // fetch books and pass to template

            return "book/catalog/catalog";
        }
    }

