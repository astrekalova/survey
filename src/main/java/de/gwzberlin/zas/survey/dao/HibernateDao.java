package de.gwzberlin.zas.survey.dao;

import java.lang.reflect.ParameterizedType;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public abstract class HibernateDao<T> extends HibernateDaoSupport implements BaseDao<T> {

	private Class<T> persistentClass;
	
	@SuppressWarnings("unchecked")
	public HibernateDao() {
		persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public T findById(long id) {
		return getHibernateTemplate().get(persistentClass, id);
	}
	
	public void saveOrUpdate(T t) {
		getHibernateTemplate().saveOrUpdate(t);
	}
}
