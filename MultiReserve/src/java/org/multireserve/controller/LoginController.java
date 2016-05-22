/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.multireserve.entity.DefaultAccount;
import org.multireserve.service.URLUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nikkor50
 */
@Controller
public class LoginController {

    protected final Log logf = LogFactory.getLog(WelcomeController.class);
    //private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private URLUserService urluserDAO;

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    //@RequiresRoles(value = "admin")
    public ModelAndView MMainSignin() {
        logf.info("######Login Controller -- Sign in");

        List<Map<String, Object>> list = urluserDAO.UrlUserDataQuery();

        logf.info("#### -- " + list.size());

        for (int i = 0; i < list.size(); i++) {
            String username = list.get(i).get("USERNAME").toString();
            logf.info("Url User Data -- " + username);
        }

        return new ModelAndView("signin");
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    //@RequiresRoles(value = "admin")
    public ModelAndView MMainSigninPOST(@ModelAttribute("account") DefaultAccount account) {

        String username = account.getUsername();
        String password = account.getPassword();

        logf.info("Login Controller: account {}" + username);
        logf.info("Login Controller: account password {}" + password);

        return new ModelAndView("redirect:/welcome.action");
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    //@RequiresRoles(value = "admin")
    public ModelAndView MMainSignup() {
        logf.info("Login Controller -- Sign Up");
        return new ModelAndView("signup");
    }

}
