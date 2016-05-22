/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.service;

import java.util.List;
import java.util.Map;
import org.multireserve.entity.dao.URLUserDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Nikkor50
 */
@Service
@Transactional
public class URLUserService {

    @Autowired
    private URLUserDAO url_user_DAO;

    public List<Map<String, Object>> UrlUserDataQuery() {
        return url_user_DAO.URLUserDataQuery();
    }
}
