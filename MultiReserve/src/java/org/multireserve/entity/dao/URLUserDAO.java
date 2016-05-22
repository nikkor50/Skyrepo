/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.multireserve.entity.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Nikkor50
 */
@Repository
public class URLUserDAO {

    @Resource
    private SessionFactory sessionFactory;

    public List<Map<String, Object>> URLUserDataQuery() {
        Query q = this.sessionFactory
                .getCurrentSession()
                .createSQLQuery(
                        "SELECT userid, username, userpasscode, mailbox, groupid FROM url_user")
                .setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
        System.out.println("###### URLUserDAO" + q.list().toString());
        return q.list();
    }

}
