package com.veerendra.biradar.crud.jdbc.controller;

import com.veerendra.biradar.api_req_res.response.ResponseDTO;
import com.veerendra.biradar.api_req_res.response.VeerAppResponseBody;
import com.veerendra.biradar.crud.jdbc.dto.Employee;
import com.veerendra.biradar.crud.jdbc.service.EmployeeService;
import com.veerendra.biradar.exception.VeerAppException;
import com.veerendra.biradar.log.AppLog;
import com.veerendra.biradar.log.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    AppLog LOG = AppLogger.getAppLog(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/emp/upload-data")
    public ResponseDTO postEmployeesData(@RequestBody Employee employee) {

        try {
            employeeService.uploadEmployeeData(employee);
            return VeerAppResponseBody.successResponse(new ArrayList<>());
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while uploading the given data to db", e);
            return VeerAppResponseBody.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while uploading the given data to db", e);
            return VeerAppResponseBody.standardError(e.getMessage());
        }

    }

    @PutMapping("/emp/update-data/{emp_id}")
    public ResponseDTO updateEmployeesData(@PathVariable("emp_id") String emp_id, @RequestBody Employee employee)
            throws VeerAppException {

        try {
            employeeService.updateEmployeesData(emp_id, employee);
            return VeerAppResponseBody.successResponse(new ArrayList<>());
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while Updating the given data to db", e);
            return VeerAppResponseBody.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while Updating the given data to db", e);
            return VeerAppResponseBody.standardError(e.getMessage());
        }

    }


    @GetMapping("/emp/get-data")
    public ResponseDTO getEmployeesData() {

        try {
            List<Employee> employeesList = employeeService.getEmployeeDetails();
            return VeerAppResponseBody.successResponse(employeesList);
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while Updating the given data to db", e);
            return VeerAppResponseBody.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while Updating the given data to db", e);
            return VeerAppResponseBody.standardError(e.getMessage());
        }

    }

    @GetMapping("/emp/get-data/{emp_id}")
    public ResponseDTO getEmployeeData(@PathVariable("emp_id") String emp_id) {

        try {
            Employee employeeData = employeeService.getEmployeeDetails(emp_id);
            return VeerAppResponseBody.successResponse(employeeData);
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while Updating the given data to db", e);
            return VeerAppResponseBody.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while Updating the given data to db", e);
            return VeerAppResponseBody.standardError(e.getMessage());
        }
    }

    @DeleteMapping("/emp/delete/{emp_id}")
    public ResponseDTO deleteEmployeeData(@PathVariable("emp_id") String emp_id) {

        try {
            employeeService.deleteEmployeeData(emp_id);
            return VeerAppResponseBody.successResponse(new ArrayList<>());
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while Deleting the given data to db", e);
            return VeerAppResponseBody.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while Deleting the given data to db", e);
            return VeerAppResponseBody.standardError(e.getMessage());
        }
    }

}
