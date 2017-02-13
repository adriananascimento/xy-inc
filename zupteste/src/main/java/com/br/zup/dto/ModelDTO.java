package com.br.zup.dto;

import java.util.List;

/**
 * Class to define a model.
 * @author adriana.nascimento
 *
 */
public class ModelDTO {

	private String modelName;
	
	private List<FieldDTO> fields;

	public ModelDTO() {
		super();
	}

	public ModelDTO(String modelName, List<FieldDTO> fields) {
		super();
		this.modelName = modelName;
		this.fields = fields;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public List<FieldDTO> getFields() {
		return fields;
	}

	public void setFields(List<FieldDTO> fields) {
		this.fields = fields;
	}

}