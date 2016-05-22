/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.controller;

import java.util.HashMap;
import java.util.Map;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Controller;

/**
 *
 * @author Nikkor50
 */
@Controller
public class PageController {

    protected final Log logf = LogFactory.getLog(WelcomeController.class);

    @RequestMapping(value = "/TimeReserve", method = RequestMethod.GET)
    public ModelAndView MM_TimeReserve(Locale locale) {
        //Account account = accountService.getAuthenticatedAccount();

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);

        Map<String, Object> model = new HashMap<>();
        model.put("account", "NOKIA");
        logf.info(formattedDate + "@Page Controller");
        //System.out.println("Welcome Controller");
        return new ModelAndView("timereserve", model);
    }
}
