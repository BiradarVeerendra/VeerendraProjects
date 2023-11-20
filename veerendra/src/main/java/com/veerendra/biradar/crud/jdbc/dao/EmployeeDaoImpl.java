package com.veerendra.biradar.crud.jdbc.dao;

import com.veerendra.biradar.crud.jdbc.dto.Employee;
import com.veerendra.biradar.exception.VeerAppException;
import com.veerendra.biradar.log.AppLog;
import com.veerendra.biradar.log.AppLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    AppLog LOG = AppLogger.getAppLog(EmployeeDaoImpl.class);

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Override
    public void uploadEmployeeData(Employee employee) throws VeerAppException {

        try {

            String empId = null;
            try {
                empId = jdbcTemplate.queryForObject(
                        "select emp_id from `veerendra`.`employee_details` where emp_id = :emp_id",
                        new MapSqlParameterSource().addValue("emp_id", employee.getEmpId()),
                        String.class);
            } catch (Exception e) {
                LOG.error("NO existing employee id found " + e.getMessage());
            }

            if (empId != null) {
                throw VeerAppException.invalidRequestError(
                        employee.getEmpId() + " this employee id is already registered", new ArrayList<>()
                );
            }

            String SQL = "INSERT INTO `veerendra`.`employee_details` "
                    + " (`emp_id`, `emp_name`, `emp_designation`, `emp_role`, `emp_dob`, `emp_doj`, `mobile_number`, "
                    + " `alternate_mobile_number`, `personal_email`, `office_email`, `emp_current_address`, "
                    + " `emp_permanent_address`, `response`) VALUES (:emp_id, :emp_name, :emp_designation, :emp_role, "
                    + " :emp_dob, :emp_doj, :mobile_number, :alternate_mobile_number, :personal_email, :office_email, "
                    + " :emp_current_address, :emp_permanent_address, :response)";

            //int rowsAffected = jdbcTemplate.update(SQL, new BeanPropertySqlParameterSource(employee));
            int rowsAffected = jdbcTemplate.update(SQL, new MapSqlParameterSource()
                    .addValue("emp_id", employee.getEmpId())
                    .addValue("emp_name", employee.getEmpName())
                    .addValue("emp_designation", employee.getEmpDesignation())
                    .addValue("emp_role", employee.getEmpRole())
                    .addValue("emp_dob", employee.getEmpDob())
                    .addValue("emp_doj", employee.getEmpDoj())
                    .addValue("mobile_number", employee.getEmpContactsList().getEmpMobileNumberList().getMobileNumber())
                    .addValue("alternate_mobile_number", employee.getEmpContactsList().getEmpMobileNumberList().getAlternateMobileNumber())
                    .addValue("personal_email", employee.getEmpContactsList().getEmpEmailList().getPersonalEmail())
                    .addValue("office_email", employee.getEmpContactsList().getEmpEmailList().getOfficeEmail())
                    .addValue("emp_current_address", employee.getEmpContactsList().getEmpAddressList().getEmCurrentAddress())
                    .addValue("emp_permanent_address", employee.getEmpContactsList().getEmpAddressList().getEmpPermanentAddress())
                    .addValue("response", employee.getResponse())
            );

            if (rowsAffected <= 0) {
                throw VeerAppException.dataInsertUpdateError("Error while inserting the data", new ArrayList<>());
            }
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while inserting employee data for the empId=" + employee.getEmpId(), e);
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while inserting employee data for the empId=" + employee.getEmpId(), e);
            throw VeerAppException.standardError();
        }

    }

    @Override
    public List<Employee> getAllEmployeesData() throws VeerAppException {
        try {

            List<Employee> employeeList = jdbcTemplate.query("select * from `veerendra`.`employee_details`",
                    new BeanPropertyRowMapper<>(Employee.class));

            if (employeeList.isEmpty()) {
                return Collections.emptyList();
            }
            return employeeList;
        } catch (DataAccessException e) {
            LOG.error("DataAccessException while getting all employee data", e);
            throw VeerAppException.standardError();
        } catch (Exception e) {
            LOG.error("Exception while getting all employee data", e);
            throw VeerAppException.standardError();
        }
    }

    @Override
    public Employee getEmployeeDetails(String empId) throws VeerAppException {

        try {

            Employee employeeData = jdbcTemplate.query(
                    "select * from `veerendra`.`employee_details` where emp_id = '" + empId + "';",
                    new BeanPropertyRowMapper<>(Employee.class)
            ).get(0);

            if (employeeData == null) {
                return new Employee();
            }
            return employeeData;
        } catch (DataAccessException e) {
            LOG.error("DataAccessException while getting employee data", e);
            throw VeerAppException.standardError();
        } catch (Exception e) {
            LOG.error("Exception while getting employee data", e);
            throw VeerAppException.standardError();
        }

    }

    @Override
    public void updateEmployeeData(String empId, Employee employee) throws VeerAppException {

        try {
            String SQL = "UPDATE `veerendra`.`employee_details` "
                    + " SET emp_name=:emp_name, emp_designation=:emp_designation, emp_role=:emp_role, emp_dob=:emp_dob, "
                    + " emp_doj=:emp_doj, mobile_number=:mobile_number, alternate_mobile_number=:alternate_mobile_number, "
                    + " personal_email=:personal_email, office_email=:office_email, emp_current_address=:emp_current_address, "
                    + " emp_permanent_address=:emp_permanent_address WHERE emp_id=:emp_id";

            int rowsAffected = jdbcTemplate.update(SQL, new MapSqlParameterSource()
                    .addValue("emp_id", empId)
                    .addValue("emp_name", employee.getEmpName())
                    .addValue("emp_designation", employee.getEmpDesignation())
                    .addValue("emp_role", employee.getEmpRole())
                    .addValue("emp_dob", employee.getEmpDob())
                    .addValue("emp_doj", employee.getEmpDoj())
                    .addValue("mobile_number", employee.getEmpContactsList().getEmpMobileNumberList().getMobileNumber())
                    .addValue("alternate_mobile_number", employee.getEmpContactsList().getEmpMobileNumberList().getAlternateMobileNumber())
                    .addValue("personal_email", employee.getEmpContactsList().getEmpEmailList().getPersonalEmail())
                    .addValue("office_email", employee.getEmpContactsList().getEmpEmailList().getOfficeEmail())
                    .addValue("emp_current_address", employee.getEmpContactsList().getEmpAddressList().getEmCurrentAddress())
                    .addValue("emp_permanent_address", employee.getEmpContactsList().getEmpAddressList().getEmpPermanentAddress())
            );

            if (rowsAffected == 0) {
                throw VeerAppException.dataInsertUpdateError(
                        "Details not updated for the emp_id=" + empId, new ArrayList<>());
            }
        } catch (VeerAppException e) {
            LOG.error("VeerAppException while update employee data for the empId=" + empId, e);
            throw VeerAppException.catchVeerAppError(e);
        } catch (Exception e) {
            LOG.error("Exception while update employee data for the empId=" + empId, e);
            throw VeerAppException.standardError();
        }

    }

    @Override
    public void deleteEmployeeData(String empId) throws VeerAppException {

        try {
            jdbcTemplate.update(
                    "delete from `veerendra`.`employee_details` where emp_id = :emp_id",
                    new MapSqlParameterSource().addValue("emp_id", empId));
        } catch (DataAccessException e) {
            LOG.error("DataAccessException while Deleting employee data", e);
            throw VeerAppException.standardError();
        } catch (Exception e) {
            LOG.error("Exception while Deleting employee data", e);
            throw VeerAppException.standardError();
        }

    }
}
