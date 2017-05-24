package com.example.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEESALARY_TBL")
public class EmployeeSalary {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @Column(name = "EMPLOYEE_POSITION", nullable = false)
    private String employeePosition;

    @Column(name = "EMPLOYEE_PAYRATE", nullable = false)
    private Long payRate;

    @Column(name = "EMPLOYEE_BONUS", nullable = false)
    private float bonus;

   
    
    

    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public Long getPayRate() {
        return payRate;
    }

    public void setPayRate(Long payRate) {
        this.payRate = payRate;
    }

    public float getBonus() {
       bonus = (float)(payRate * 0.1);
        return bonus;
    }

    public void setBonus(float bonus) {
        this.bonus = bonus;
    }

}
