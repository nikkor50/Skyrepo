/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Nikkor50
 */
public class LoginInterceptor implements HandlerInterceptor {

    //protected final Log logger = LogFactory.getLog(LoginInterceptor.class);
    private static final Logger logger = LoggerFactory.getLogger(LoginInterceptor.class);

    String nologin = "http://www.bing.com";

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler) throws Exception {
        logger.info("Pre-handle");
        HttpSession session = request.getSession();
        logger.info(request.getParameter("sessionId"));

        String servletpath = request.getServletPath();

        if (servletpath != null && servletpath.equals("/logout.do")) {
            return true;
        } else {
            String contextpath = request.getContextPath();
            logger.info("context path = " + contextpath);

            // query parameter
            String querystring = request.getQueryString() == null ? ""
                    : request.getQueryString();
            //System.out.println("query string = " + querystring);

            String[] qs = querystring.split("&");
            String qsv = "";
            int len = qs.length;
            for (int i = 0; i < len; i++) {
                if (qs[i].startsWith("method=")) {
                    qsv = qs[i].substring(7);
                }
            }
            String empno = (String) session.getAttribute("empno");

        }

        return true;

    }

    @Override
    public void postHandle(HttpServletRequest request,
            HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        //System.out.println("Post-handle");
        logger.info("Post-handle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request,
            HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        //System.out.println("after-Completion");
        logger.info("after-Completion");

    }

}
