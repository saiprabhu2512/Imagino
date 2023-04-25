package org.employee.repositopre;

import org.employee.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpDetailsRepo extends JpaRepository<Emp, Long> {

}
