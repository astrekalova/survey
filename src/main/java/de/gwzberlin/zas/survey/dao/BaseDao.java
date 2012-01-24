package de.gwzberlin.zas.survey.dao;

public interface BaseDao<T> {

	T findById(long id);

	void saveOrUpdate(T t);
}
