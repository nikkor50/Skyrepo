/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.controller;

import java.util.Enumeration;
import java.util.Iterator;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
public class WelcomeController {

    protected final Log logf = LogFactory.getLog(WelcomeController.class);

    @RequestMapping("welcome")
    public ModelAndView MMaint(HttpServletRequest request,
            HttpServletResponse response) throws Exception {
        ModelAndView mav = new ModelAndView();
        System.out.println("Welcome Controller");
        mav.setViewName("Welcome");
        return mav;
    }

    @RequestMapping("logout.action")
    public void logout(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // ModelAndView mov = new ModelAndView();
        System.out.println("logout");
        HttpSession session = request.getSession();
        Enumeration<?> enu = session.getAttributeNames();
        Vector<String> v = new Vector<String>();
        while (enu.hasMoreElements()) {
            v.add((String) enu.nextElement());
        }
        Iterator<String> ite = v.iterator();
        while (ite.hasNext()) {
            String sessionid = (String) ite.next();
            // System.out.println(sessionid);
            session.removeAttribute(sessionid);
        }
        response.sendRedirect("http://www.bing.com");
    }
}
