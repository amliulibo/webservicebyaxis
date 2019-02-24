package com.java.service;

import java.util.List;

import com.java.entity.PIButtonDTO;
import com.java.entity.PIFormDTO;

public interface PIButtonService
{

	public List<PIButtonDTO> selectPiButton(String formID,String buttonName);
}
