package com.veerendra.biradar.crud.jdbc.service;

import com.veerendra.biradar.crud.jdbc.dto.Employee;
import com.veerendra.biradar.exception.VeerAppException;

import java.util.List;

public interface EmployeeService {

    void uploadEmployeeData(Employee employee) throws VeerAppException;

    void updateEmployeesData(String empId, Employee employee) throws VeerAppException ;

    List<Employee> getEmployeeDetails() throws VeerAppException;

    Employee getEmployeeDetails(String empId) throws VeerAppException;

    void deleteEmployeeData(String empId) throws VeerAppException;
}
