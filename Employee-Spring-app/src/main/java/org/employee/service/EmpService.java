package org.employee.service;

import java.util.List;

import org.employee.dto.EmpDto;

public interface EmpService {
	
	public EmpDto AddEmp(EmpDto dto);

	public 	List<EmpDto> GetEmployees(int pageno, int psgesize, String sortby, String sortdrc);
	

	Double getEmptaxcalCulatiom(Long id);
}
