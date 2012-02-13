package de.gwzberlin.zas.survey.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Repository;

import de.gwzberlin.zas.survey.db.Alternative;

@Repository("alternativeDao")
public class AlternativeDaoImpl extends HibernateDao<Alternative> implements AlternativeDao {

	public List<Alternative> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Alternative.class);
		return getHibernateTemplate().findByCriteria(criteria);
	}	
}
