package com.veerendra.biradar.crud.jdbc.dao;

import com.veerendra.biradar.crud.jdbc.dto.Employee;
import com.veerendra.biradar.exception.VeerAppException;

import java.util.List;

public interface EmployeeDao {

    void uploadEmployeeData(Employee employee) throws VeerAppException;

    List<Employee> getAllEmployeesData() throws VeerAppException;

    Employee getEmployeeDetails(String empId) throws VeerAppException;

    void updateEmployeeData(String empId, Employee employee) throws VeerAppException;

    void deleteEmployeeData(String empId) throws VeerAppException;
}
