package com.chriscoding.mylibraryspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


    @Controller
    @RequestMapping(value="book")
    public class CatalogController extends AbstractController {

        @RequestMapping(value = "catalog")
        public String blogIndex(Model model) {
            model.addAttribute("catalogs", bookDao.findAll());

            // TODO - fetch books and pass to template

            return "book/catalog/catalog";
        }
    }

