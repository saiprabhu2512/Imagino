package org.employee.service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.employee.dto.EmpDto;
import org.employee.exception.ResourceNotFoundExceptiontcl;
import org.employee.model.Emp;
import org.employee.model.EmpTaxDetails;
import org.employee.repositopre.EmpDetailsRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImp implements EmpService {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private EmpDetailsRepo empRepository;
	
	@Override
	public Double getEmptaxcalCulatiom(Long id) {
	EmpTaxDetails emptaxdetails=new EmpTaxDetails();
		Emp employeebyid = empRepository.findById(id).get();
				if(employeebyid==null) {
				throw new ResourceNotFoundExceptiontcl("EmpNotFoundException");
				}
				EmpDto empDto = modelMapper.map(employeebyid, EmpDto.class);
         LocalDate empaslarystartingdate = empDto.getDOJ();
         LocalDate empsalaryendingdate =LocalDate.now()  ;
         long totalemployeemonthsworking = ChronoUnit.MONTHS.between(empaslarystartingdate, empsalaryendingdate);
	    	Double totalsalaryofemp = empDto.getSalary() *  totalemployeemonthsworking ;
	    	Double tax = 0.0;
		if (totalsalaryofemp > 250000 && totalsalaryofemp<=500000) 
		{

			return tax = (totalsalaryofemp-250000)*0.05;
			
		}
		else if (totalsalaryofemp > 500000 && totalsalaryofemp <= 1000000) 
		{
			return tax = 12500+(totalsalaryofemp-500000)*0.1;
		}
		else if (totalsalaryofemp > 1000000 ) 
		{
	
			return tax =112500+(totalsalaryofemp-1000000)*0.2 ;
		}
		Double emptax = 0.0;
		
		if(totalsalaryofemp>2500000) {
			return emptax=(totalsalaryofemp-2500000)*0.02;
		}
		double emptotaltax =tax+emptax;
		emptaxdetails.setEmployeeID(empDto.getEmployeeID());
		emptaxdetails.setFirstName(empDto.getFirstname());
		emptaxdetails.setLastName(empDto.getLastname());
		emptaxdetails.setEmail(empDto.getEmail());
		emptaxdetails.setPhoneNumber(empDto.getPhonenumber());
		emptaxdetails.setDOJ(empDto.getDOJ());
		emptaxdetails.setSalary(empDto.getSalary());
		emptaxdetails.setTotalTexAmount(tax);
		emptaxdetails.setTotalCessAmount(emptax);
		
		return emptotaltax; 
	}

	

	@Override
	public EmpDto AddEmp(EmpDto employeedto) {
		EmpDto empDto = null;
		Emp emp = modelMapper.map(employeedto, Emp.class);

		try {
			Emp addemp = empRepository.save(emp);

		} catch (Exception e) {
			throw new ResourceNotFoundExceptiontcl("emp is allready regestered ");
		}
		empDto = modelMapper.map(empDto, EmpDto.class);
		return empDto;

	}

	
	@Override
	public List<EmpDto> GetEmployees(int pageno ,int psgesize, String sortby,String sortdrc) {
		Sort sort =sortdrc.equalsIgnoreCase(Sort.Direction.ASC.name())?
    			Sort.by(sortby).ascending():Sort.by(sortby).descending();
    	
    	Pageable pag = PageRequest.of(pageno, psgesize, sort);
  
    	Page<Emp>allemploylist =this.empRepository.findAll(pag);
    	List<EmpDto>allemploydtolist = allemploylist.stream()
    			.map((Employee)-> modelMapper
    			.map(Employee, EmpDto.class)).collect(Collectors.toList());
    		
		return allemploydtolist;
	}



	
	
	

 

	

	

	
}
