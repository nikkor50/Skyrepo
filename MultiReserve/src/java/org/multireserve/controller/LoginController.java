/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nikkor50
 */
@Controller
public class LoginController {
    
        protected final Log logf = LogFactory.getLog(WelcomeController.class);

    @RequestMapping("signin")
    public ModelAndView MMaint(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        System.out.println("Login Controller");
        mav.setViewName("Signin");
        return mav;
    }
    
}
