/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.multireserve.entity.DefaultAccount;
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

    @RequestMapping(value = "/signin", method = RequestMethod.GET)
    //@RequiresRoles(value = "admin")
    public ModelAndView MMainSignin() {
        logf.info("Login Controller -- Sign in");
        return new ModelAndView("signin");
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    //@RequiresRoles(value = "admin")
    public ModelAndView MMainSigninPOST(@ModelAttribute("account") DefaultAccount account) {

        String username = account.getUsername();
        String givenName = account.getGivenName();
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
