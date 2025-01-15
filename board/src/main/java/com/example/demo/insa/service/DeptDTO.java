package com.example.demo.insa.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeptDTO {
	private Long departmentId;
	private String departmentName;
	private Long managerId;
	private Long locationId;
}
