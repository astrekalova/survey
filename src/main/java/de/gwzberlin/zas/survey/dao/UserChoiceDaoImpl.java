package de.gwzberlin.zas.survey.dao;

import org.springframework.stereotype.Repository;

import de.gwzberlin.zas.survey.db.UserChoice;

@Repository("userChoiceDao")
public class UserChoiceDaoImpl extends HibernateDao<UserChoice> implements UserChoiceDao {

}
