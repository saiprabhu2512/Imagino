package org.employee.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="emptaxdetails")
public class EmpTaxDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long EmployeeID;
	@Column(nullable = false)
	private String FirstName;
	@Column(nullable = false)
	private String LastName;
	@Column(nullable = false)
	private String Email;
	@Column(nullable = false)
	private String PhoneNumber;
	@Column(nullable = false)
	private LocalDate DOJ;
	@Column(nullable = false)
	private Double Salary;
	@Column(nullable = false)
	private Double TotalTexAmount;
	@Column(nullable = false)
	private Double TotalCessAmount ;
	
	
	
	public Long getEmployeeID() {
		return EmployeeID;
	}
	public void setEmployeeID(Long employeeID) {
		EmployeeID = employeeID;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public LocalDate getDOJ() {
		return DOJ;
	}
	public void setDOJ(LocalDate dOJ) {
		DOJ = dOJ;
	}
	public Double getSalary() {
		return Salary;
	}
	public void setSalary(Double salary) {
		Salary = salary;
	}
	public Double getTotalTexAmount() {
		return TotalTexAmount;
	}
	public void setTotalTexAmount(Double totalTexAmount) {
		TotalTexAmount = totalTexAmount;
	}
	public Double getTotalCessAmount() {
		return TotalCessAmount;
	}
	public void setTotalCessAmount(Double totalCessAmount) {
		TotalCessAmount = totalCessAmount;
	}
	public EmpTaxDetails(Long employeeID, String firstName, String lastName, String email, String phoneNumber,
			LocalDate dOJ, Double salary, Double totalTexAmount, Double totalCessAmount) {
		super();
		EmployeeID = employeeID;
		FirstName = firstName;
		LastName = lastName;
		Email = email;
		PhoneNumber = phoneNumber;
		DOJ = dOJ;
		Salary = salary;
		TotalTexAmount = totalTexAmount;
		TotalCessAmount = totalCessAmount;
	}
	public EmpTaxDetails() {
		super();
	}
	@Override
	public String toString() {
		return "EmployeeTaxDetails [EmployeeID=" + EmployeeID + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Email=" + Email + ", PhoneNumber=" + PhoneNumber + ", DOJ=" + DOJ + ", Salary=" + Salary
				+ ", TotalTexAmount=" + TotalTexAmount + ", TotalCessAmount=" + TotalCessAmount + "]";
	}
	
	
	

}
