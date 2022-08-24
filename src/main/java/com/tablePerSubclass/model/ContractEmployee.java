package com.tablePerSubclass.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ContractEmployee")
@PrimaryKeyJoinColumn(name="Id")
public class ContractEmployee extends Employee{

    @Column(name = "hourlyrate")
    private double hourlyrate;

    public double getHourlyrate() {
        return hourlyrate;
    }

    public void setHourlyrate(double hourlyrate) {
        this.hourlyrate = hourlyrate;
    }
}
