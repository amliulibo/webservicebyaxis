package com.java.service;

import java.util.List;

import com.java.entity.PIFormDTO;

public interface PiFormService
{

	public List<PIFormDTO> selectPiForm(String menuid,String formName);
}
