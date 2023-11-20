package com.veerendra.biradar.crud.jdbc.service;

import com.veerendra.biradar.crud.jdbc.dao.EmployeeDao;
import com.veerendra.biradar.crud.jdbc.dto.Employee;
import com.veerendra.biradar.exception.VeerAppException;
import com.veerendra.biradar.log.AppLog;
import com.veerendra.biradar.log.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    AppLog LOG = AppLogger.getAppLog(EmployeeServiceImpl.class);

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void uploadEmployeeData(Employee employee) throws VeerAppException {

        try {

            if (employee.getEmpId() == null || employee.getEmpId().isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "Employee id should not be empty/blank/null", new ArrayList<>()
                );
            }

            if (employee.getEmpName() == null || employee.getEmpName().isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "Employee name should not be empty/blank/null", new ArrayList<>()
                );
            }

            if (employee.getEmpDob() == null || employee.getEmpDob().isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "Employee dob should not be empty/blank/null", new ArrayList<>()
                );
            }

            if (employee.getEmpDoj() == null || employee.getEmpDoj().isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "Employee doj should not be empty/blank/null", new ArrayList<>()
                );
            }

            if (employee.getEmpDesignation() == null || employee.getEmpDesignation().isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "Employee designation should not be empty/blank/null", new ArrayList<>()
                );
            }

            if (employee.getEmpRole() == null || employee.getEmpRole().isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "Employee role should not be empty/blank/null", new ArrayList<>()
                );
            }

            employee.setResponse(employee.toString());

            employeeDao.uploadEmployeeData(employee);

        } catch (VeerAppException e) {
            LOG.error("VeerAppException for the empId=" + employee.getEmpId(), e);
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            throw VeerAppException.standardError();
        }

    }

    @Override
    public void updateEmployeesData(String empId, Employee employee) throws VeerAppException {

        try {

            if (employee == null || employee.toString().isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "No data given to update for the emp_id=" + empId, new ArrayList<>()
                );
            }

            if (empId == null || empId.isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "Employee id should not be empty/blank/null", new ArrayList<>()
                );
            }
            employeeDao.updateEmployeeData(empId, employee);
        } catch (VeerAppException e) {
            LOG.error("VeerAppException for the empId=" + empId, e);
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            throw VeerAppException.standardError();
        }

    }

    @Override
    public List<Employee> getEmployeeDetails() throws VeerAppException {
        try {
            return employeeDao.getAllEmployeesData();
        } catch (VeerAppException e) {
            LOG.error("VeerAppException ", e);
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception ", e);
            throw VeerAppException.standardError();
        }
    }

    @Override
    public Employee getEmployeeDetails(String empId) throws VeerAppException {

        try {
            if (empId == null || empId.isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "Employee id should not be empty/blank/null", new ArrayList<>()
                );
            }

            return employeeDao.getEmployeeDetails(empId);

        } catch (VeerAppException e) {
            LOG.error("VeerAppException for the empId=" + empId, e);
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception for the empId=" + empId, e);
            throw VeerAppException.standardError();
        }

    }

    @Override
    public void deleteEmployeeData(String empId) throws VeerAppException {

        try {
            if (empId == null || empId.isEmpty()) {
                throw VeerAppException.invalidRequestError(
                        "Employee id should not be empty/blank/null", new ArrayList<>()
                );
            }
            employeeDao.deleteEmployeeData(empId);

        } catch (VeerAppException e) {
            LOG.error("VeerAppException for the empId=" + empId, e);
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception for the empId=" + empId, e);
            throw VeerAppException.standardError();
        }

    }

}
