package com.br.zup.dto;

public class FieldDTO {

	private String fieldName;
	
	private String fieldType;

	public FieldDTO() {
		super();
	}

	public FieldDTO(String fieldName, String fieldType) {
		super();
		this.fieldName = fieldName;
		this.fieldType = fieldType;
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
	
}