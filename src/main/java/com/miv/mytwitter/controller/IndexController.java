package com.miv.mytwitter.controller;

import com.miv.mytwitter.domain.User;
import com.miv.mytwitter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
public class IndexController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showIndex(final HttpServletRequest request, Principal principal, Model model) {
        final String currentUserLogin = principal.getName();
        User user = userService.findByLogin(currentUserLogin);
        model.addAttribute("profile", "/" + currentUserLogin);

        return "index";
    }
}
