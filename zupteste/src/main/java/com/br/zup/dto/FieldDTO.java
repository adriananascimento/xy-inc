package com.br.zup.dto;

/**
 * Class to define a field of model.
 * @author adriana.nascimento
 *
 */
public class FieldDTO {

	private String fieldName;
	
	private String fieldType;
	
	private Boolean notNull;

	public FieldDTO() {
		super();
	}

	public FieldDTO(String fieldName, String fieldType, Boolean notNull) {
		super();
		this.fieldName = fieldName;
		this.fieldType = fieldType;
		this.notNull = notNull;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public Boolean getNotNull() {
		return notNull;
	}

	public void setNotNull(Boolean notNull) {
		this.notNull = notNull;
	}
	
}