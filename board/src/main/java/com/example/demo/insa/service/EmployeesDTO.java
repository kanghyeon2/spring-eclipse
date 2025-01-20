package com.example.demo.insa.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeesDTO {
	private Long employeeId;
	
	@NotNull(message = "필수 입력 항목입니다.")
	private String firstName;
	
	@NotNull(message = "필수 입력 항목입니다.")
	private String lastName;
	
	@NotNull
	@Email
	private String email;
	private String phoneNumber;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private Long salary;
	private Double commissionPct;
	private Long managerId;
	private Long departmentId;
}
