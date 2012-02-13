package de.gwzberlin.zas.survey.dao;

import org.springframework.stereotype.Repository;


@Repository("userDao")
public class UserDaoImpl extends HibernateDao<User> implements UserDao {

}
