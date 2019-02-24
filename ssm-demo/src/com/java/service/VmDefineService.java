package com.java.service;

import java.util.List;
import com.java.entity.VMDefineDTO;

public interface VmDefineService
{
	public List<VMDefineDTO> selectVmDefine(String voucherId,String voucherName);
}
