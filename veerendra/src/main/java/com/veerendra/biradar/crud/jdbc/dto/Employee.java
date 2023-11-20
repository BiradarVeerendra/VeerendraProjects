package com.veerendra.biradar.crud.jdbc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

@JsonIgnoreProperties
public class Employee implements Serializable {

    private static final long serialVersionUID = 2409168269491619999L;

    @JsonProperty("id")
    private Long id;
    @JsonProperty("emp_id")
    private String empId;
    @JsonProperty("emp_name")
    private String empName;
    @JsonProperty("emp_designation")
    private String empDesignation;
    @JsonProperty("emp_role")
    private String empRole;
    @JsonProperty("emp_dob")
    private String empDob;
    @JsonProperty("emp_doj")
    private String empDoj;
    @JsonProperty("emp_contacts_list")
    private EmpContacts empContactsList;
    @JsonProperty("response")
    private String response;
    @JsonProperty("create_date")
    private String create_date;
    @JsonProperty("update_date")
    private String update_date;


    @JsonIgnoreProperties
    public static class EmpContacts {

        @JsonProperty("emp_mobile_number")
        private EmpMobileNumber empMobileNumberList;
        @JsonProperty("emp_email_list")
        private EmpEmail empEmailList;
        @JsonProperty("emp_address_list")
        private EmpAddressList empAddressList;

        public EmpContacts() {
        }

        @JsonIgnoreProperties
        public static class EmpMobileNumber {

            @JsonProperty("mobile_number")
            private String mobileNumber;

            @JsonProperty("alternate_mobile_number")
            private String alternateMobileNumber;

            public EmpMobileNumber() {
            }

            public String getMobileNumber() {
                return mobileNumber;
            }

            public void setMobileNumber(String mobileNumber) {
                this.mobileNumber = mobileNumber;
            }

            public String getAlternateMobileNumber() {
                return alternateMobileNumber;
            }

            public void setAlternateMobileNumber(String alternateMobileNumber) {
                this.alternateMobileNumber = alternateMobileNumber;
            }

            @Override
            public String toString() {
                return "EmpMobileNumber{" +
                        "mobileNumber='" + mobileNumber + '\'' +
                        ", alternateMobileNumber='" + alternateMobileNumber + '\'' +
                        '}';
            }
        }

        @JsonIgnoreProperties
        public static class EmpEmail {

            @JsonProperty("personal_email")
            private String personalEmail;
            @JsonProperty("office_email")
            private String officeEmail;

            public EmpEmail() {
            }

            public String getPersonalEmail() {
                return personalEmail;
            }

            public void setPersonalEmail(String personalEmail) {
                this.personalEmail = personalEmail;
            }

            public String getOfficeEmail() {
                return officeEmail;
            }

            public void setOfficeEmail(String officeEmail) {
                this.officeEmail = officeEmail;
            }

            @Override
            public String toString() {
                return "EmpEmail{" +
                        "personalEmail='" + personalEmail + '\'' +
                        ", officeEmail='" + officeEmail + '\'' +
                        '}';
            }
        }

        @JsonIgnoreProperties
        public static class EmpAddressList {

            @JsonProperty("emp_current_address")
            private String emCurrentAddress;
            @JsonProperty("emp_permanent_address")
            private String empPermanentAddress;

            public String getEmCurrentAddress() {
                return emCurrentAddress;
            }

            public void setEmCurrentAddress(String emCurrentAddress) {
                this.emCurrentAddress = emCurrentAddress;
            }

            public String getEmpPermanentAddress() {
                return empPermanentAddress;
            }

            public void setEmpPermanentAddress(String empPermanentAddress) {
                this.empPermanentAddress = empPermanentAddress;
            }

            @Override
            public String toString() {
                return "EmpAddressList{" +
                        "empCurrentAddress='" + emCurrentAddress + '\'' +
                        ", empPermanentAddress='" + empPermanentAddress + '\'' +
                        '}';
            }
        }

        public EmpMobileNumber getEmpMobileNumberList() {
            return empMobileNumberList;
        }

        public void setEmpMobileNumberList(EmpMobileNumber empMobileNumberList) {
            this.empMobileNumberList = empMobileNumberList;
        }

        public EmpEmail getEmpEmailList() {
            return empEmailList;
        }

        public void setEmpEmailList(EmpEmail empEmailList) {
            this.empEmailList = empEmailList;
        }

        public EmpAddressList getEmpAddressList() {
            return empAddressList;
        }

        public void setEmpAddressList(EmpAddressList empAddressList) {
            this.empAddressList = empAddressList;
        }

        @Override
        public String toString() {
            return "EmpContacts{" +
                    "empMobileNumberList=" + empMobileNumberList +
                    ", empEmailList=" + empEmailList +
                    ", empAddressList=" + empAddressList +
                    '}';
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getEmpDesignation() {
        return empDesignation;
    }

    public void setEmpDesignation(String empDesignation) {
        this.empDesignation = empDesignation;
    }

    public String getEmpRole() {
        return empRole;
    }

    public void setEmpRole(String empRole) {
        this.empRole = empRole;
    }

    public String getEmpDob() {
        return empDob;
    }

    public void setEmpDob(String empDob) {
        this.empDob = empDob;
    }

    public String getEmpDoj() {
        return empDoj;
    }

    public void setEmpDoj(String empDoj) {
        this.empDoj = empDoj;
    }

    public EmpContacts getEmpContactsList() {
        return empContactsList;
    }

    public void setEmpContactsList(EmpContacts empContactsList) {
        this.empContactsList = empContactsList;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getCreate_date() {
        return create_date;
    }

    public void setCreate_date(String create_date) {
        this.create_date = create_date;
    }

    public String getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(String update_date) {
        this.update_date = update_date;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empId='" + empId + '\'' +
                ", empName='" + empName + '\'' +
                ", empDesignation='" + empDesignation + '\'' +
                ", empRole='" + empRole + '\'' +
                ", empDob='" + empDob + '\'' +
                ", empDoj='" + empDoj + '\'' +
                ", empContactsList=" + empContactsList +
                ", response='" + response + '\'' +
                ", create_date='" + create_date + '\'' +
                ", update_date='" + update_date + '\'' +
                '}';
    }
}
