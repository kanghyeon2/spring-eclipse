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
	@NotNull(message = "사번은 필수입니다.")
	private Long employeeId;
	@NotBlank(message = "이름은 필수 입력 항목입니다.")
	private String firstName;
	@NotBlank(message = "이름은 필수 입력 항목입니다.")
	private String lastName;
	@NotNull
	@Email
	private String email;
	private String phoneNumber;
	@NotNull
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private Long salary;
	private Double commissionPct;
	private Long managerId;
	private Long departmentId;
}
