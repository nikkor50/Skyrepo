/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.controller;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nikkor50
 */
@Controller
public class WelcomeController {

    protected final Log logf = LogFactory.getLog(WelcomeController.class);
    //private static final Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    /**
     * URI for accessing the "home" page of the web application.
     * <p/>
     * Sample usages of isAuthenticated or isRemembered methods from
     * {@link org.apache.shiro.subject.Subject} can be seen here.
     * <p/>
     * Instead of forcing the authc filter on this resource, we handle the
     * validation of the user in this method. Just to show shiro tools for this.
     *
     * @return
     */
    //@RequestMapping("welcome")
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView MMaint(Locale locale) {
        //Account account = accountService.getAuthenticatedAccount();

        logf.info("Welcome home! the client locale is " + locale.toString());

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        String formattedDate = dateFormat.format(date);

        Map<String, Object> model = new HashMap<>();
        model.put("account", "NOKIA");
        logf.info(formattedDate + "@Welcome Controller");
        //System.out.println("Welcome Controller");
        return new ModelAndView("Welcome", model);
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
