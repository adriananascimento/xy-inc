package com.br.zup.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.transaction.Transactional;

import org.codehaus.jettison.json.JSONObject;

import com.br.zup.dao.ModelDAO;
import com.br.zup.dto.ModelDTO;

@Stateless
@LocalBean
public class ModelService {

	@Inject
	private ModelDAO modelDAO;

	@Transactional
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void addModel(ModelDTO modelDTO) throws Exception {
		modelDAO.createNewModel(modelDTO);
	}

	public List<Object> getAllObjs(String model) throws Exception {
		return modelDAO.getAll(model);
	}

	public List<Object> getObjById(String model, String id) throws Exception {
		return modelDAO.getById(model, id);
	}

	public void addObj(String model, JSONObject json) throws Exception {
		List<String> keys = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		
		for (int i = 0; i < json.names().length(); i++) {
			keys.add(json.names().getString(i));
			values.add(json.get(json.names().getString(i)));
		}

		modelDAO.addObj(model, keys, values);
	}
	
	public void updateObj(String model, String id, JSONObject json) throws Exception {
		List<String> keys = new ArrayList<String>();
		List<Object> values = new ArrayList<Object>();
		
		for (int i = 0; i < json.names().length(); i++) {
			keys.add(json.names().getString(i));
			values.add(json.get(json.names().getString(i)));
		}

		modelDAO.updateObj(model, id, keys, values);
	}

	public void removeObj(String model, String id) throws Exception{
		modelDAO.removeObj(model, id);
	}

}
