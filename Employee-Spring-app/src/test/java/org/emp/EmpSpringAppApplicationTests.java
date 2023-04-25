package org.emp;

import java.util.List;

import org.aspectj.lang.annotation.Before;
import org.assertj.core.api.Assertions;
import org.employee.model.Emp;
import org.employee.repositopre.EmpDetailsRepo;
import org.employee.service.EmpService;
import org.junit.jupiter.api.DisplayName;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmpSpringAppApplicationTests {

	@Mock
	private EmpDetailsRepo empRepository;

	@InjectMocks
	private EmpService empService;

	@Before(value = "")
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@DisplayName("FindAllEmployee")
	public void GivenEmployees_whenSave_thenreturnEmpList() {

		Emp emp = new Emp(1L, "sai", "prabhu");

		Emp emp1 = new Emp(2L, "siva", "kumar");

		empRepository.save(emp);
		empRepository.save(emp1);

		List<Emp> emplist = empRepository.findAll();

		Assertions.assertThat(emplist.size()).isEqualTo(2);
	}

}
