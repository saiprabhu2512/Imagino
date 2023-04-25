package org.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.employee.dto.EmpDto;
import org.employee.service.EmpServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api")
public class EmpController {
	@Autowired
	private EmpServiceImp EmployeeService;
	
	
	
	Logger logger =LoggerFactory.getLogger(EmpController.class);


	@GetMapping("/employees/{id}")
	public ResponseEntity<?>getEmpTax(@PathVariable("id")Long id){
		 logger.debug("grt emp Tax  ");
		return new ResponseEntity<Double>(EmployeeService.getEmptaxcalCulatiom(id),HttpStatus.OK);
		
	}

	
	@PostMapping("/employees")
	public ResponseEntity<?> addemp(@Validated @RequestBody EmpDto employeedto, BindingResult binres) {
		if (binres.hasErrors()) {
			Map<String, String> validationsMap = new HashMap<String, String>();
			for (FieldError error : binres.getFieldErrors()) {
				validationsMap.put(error.getField(), error.getDefaultMessage());
			}
			return new ResponseEntity<Map<String, String>>(validationsMap, HttpStatus.BAD_REQUEST);

		} else {

			EmpDto st = EmployeeService.AddEmp(employeedto);
	        logger.debug("emp is added ");
			return new ResponseEntity<EmpDto>(st, HttpStatus.CREATED);
		}
	}
	
	

	
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmpDto>> getallempl(
			@RequestParam(value = "Pageno", defaultValue = "0", required = false) Integer pageno,
			@RequestParam(value = "pagesize", defaultValue = "4", required = false) Integer pagesize,
			@RequestParam(value = "sotrby", defaultValue = "empid", required = false) String sotrby,
			@RequestParam(value = "sotrdsc", defaultValue = "asc", required = false) String sotrdsc) {
		List<EmpDto> employess = EmployeeService.GetEmployees(pageno, pagesize, sotrby, sotrdsc);
		 logger.debug("get list of emp ");
		return new ResponseEntity<List<EmpDto>>(employess, HttpStatus.OK);

	}
	
	
	
	
	

	

}
