package org.example.smart_schedulerbackend.model.dto;

import lombok.Data;

@Data
public class DepartmentInformationDTO {
    private String departmentNumber;
    private String departmentName;
    private String departmentSerialNumber;
    private String englishName;
    private String departmentAbbreviation;
    private String departmentAddress;
    private String entity;
    private String headOfAdministration;
    private String headOfThePartyCommittee;
    private String establishmentYear;
    private String expirationDate;
    private String organizationType;
    private String unitType;
    private String superiorDepartment;
    private String fixedSchoolBuilding;
    private String facultiesAndDepartments;
    private String facultyOfClasses;
    private String landline;
    private String noteDescription;
    private String status; // 注意：原表中为Statu，这里修正为statu以符合Java命名规范
    private String courseDevelopment;
}
