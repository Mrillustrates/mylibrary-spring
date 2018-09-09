package com.chriscoding.mylibraryspring.controllers;

import com.chriscoding.mylibraryspring.models.Librarian;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping(value="book")
public class AuthenticationControler extends AbstractController {



    @RequestMapping(value = "user", method = RequestMethod.GET)
    public String signupForm() {
        return "book/user/signup";
    }

    @RequestMapping(value = "user", method = RequestMethod.POST)
    public String signup(HttpServletRequest request, Model model) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String verify = request.getParameter("verify");
        HttpSession session = request.getSession();
        String usercheck = request.getParameter("username");

        if(!Librarian.isValidUsername(username)){
            //System.out.println("Invalid usernames");
            return "book/user/signup";
        }
        if(!Librarian.isValidPassword(password)) {
            //System.out.println("invalid password");
            return "book/user/signup";
        }
        if(!password.equals(verify)){
            //System.out.println("Invalid password");
            return "book/user/signup";
        }
        /*if(username.equals(usercheck)){
            System.out.println("Username already taken");
            return "book/user/signup";

        }*/


        Librarian newUser = new Librarian(username,password);
        librarianDao.save(newUser);
        setUserInSession(session, newUser);

        return "redirect:newbook";
    }


    @RequestMapping(value = "user/login", method = RequestMethod.GET)
    public String loginForm() {
        return "book/user/login";
    }

    @RequestMapping(value = "user/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request, Model model) {

        // TODO - implement login
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Librarian logs = librarianDao.findByUsername(username);
        HttpSession session = request.getSession();


        if(logs.isMatchingPassword(password)){

            setUserInSession(session, logs);
            return "redirect:/book/newbook";

        }
        {
            return "book/user/login";


        }

    }
    @RequestMapping(value = "user/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().invalidate();
        return "redirect:book/user";
    }
}
