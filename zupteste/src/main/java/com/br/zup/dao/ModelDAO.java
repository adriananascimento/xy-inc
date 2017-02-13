package com.br.zup.dao;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import com.br.zup.dto.FieldDTO;
import com.br.zup.dto.ModelDTO;

public class ModelDAO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 606928056037320676L;
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected CriteriaBuilder criteriaBuilder;

	@PostConstruct
	protected void init() {
		criteriaBuilder = entityManager.getCriteriaBuilder();
	}
	
	public ModelDAO() {
		super();
	}

	public void createNewModel( ModelDTO modelDTO ) {
		StringBuilder createTableQuery = new StringBuilder("CREATE TABLE IF NOT EXISTS " + modelDTO.getModelName().toLowerCase() + " (");
		for (FieldDTO item : modelDTO.getFields()) {
			createTableQuery.append(item.getFieldName().toLowerCase() + " ");
			createTableQuery.append(item.getFieldType().toLowerCase() + ", ");
		}
		
        createTableQuery.replace(createTableQuery.lastIndexOf(","),createTableQuery.length(), ")");
        
		Query query = entityManager.createNativeQuery(createTableQuery.toString());
		query.executeUpdate();
	}
	
	public List<Object> getAll(String model) {
		String sql = "SELECT * FROM " + model;
		Query query = entityManager.createNativeQuery(sql);
		return query.getResultList();
	}
	
	public List<Object> getById(String model, String id) {
		String sql = "SELECT * FROM " + model + " WHERE ID = " + id;
		Query query = entityManager.createNativeQuery(sql);
		return query.getResultList();
	}
	
	public void addObj(String model, List<String> keys, List<Object> values) {
		StringBuilder sql = new StringBuilder("INSERT INTO " + model + " (");
		for (String key : keys) {
			sql.append(key + ", ");
		}
		sql.replace(sql.lastIndexOf(","),sql.length(), ")");
		sql.append("VALUES (");
		for (Object object : values) {
			if ( object instanceof String ) {
				sql.append("'" + object + "', ");
			} else {
				sql.append(object + ", ");
			}
		}
		sql.replace(sql.lastIndexOf(","),sql.length(), ");");
		
		Query query = entityManager.createNativeQuery(sql.toString());
		query.executeUpdate();
	}
	
	public void updateObj(String model, String id, List<String> keys, List<Object> values) {
		StringBuilder sql = new StringBuilder("UPDATE " + model + " SET ");
		for (int i = 0; i < keys.size(); i++) {
			sql.append(keys.get(i) + "="); 
			if (values.get(i) instanceof String ) {
				sql.append("'" + values.get(i) + "', ");
			} else {
				sql.append(values.get(i) + ", ");
			}
		}
		
		sql.replace(sql.lastIndexOf(","),sql.length(), " ");
		sql.append(" WHERE id = " + id);
		
		Query query = entityManager.createNativeQuery(sql.toString());
		query.executeUpdate();
	}

	public void removeObj(String model, String id) {
		String sql = "DELETE FROM " + model + " WHERE ID = " + id;
		Query query = entityManager.createNativeQuery(sql);
		query.executeUpdate();
	}

}
