package de.gwzberlin.zas.survey.dao;

import java.util.List;

import de.gwzberlin.zas.survey.db.Alternative;

public interface AlternativeDao extends BaseDao<Alternative> {

	List<Alternative> findAll();
	Alternative findById(long id);
}
