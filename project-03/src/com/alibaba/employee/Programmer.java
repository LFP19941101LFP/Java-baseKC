package com.alibaba.employee;

import com.alibaba.service.Status;

/**
 * 陈序猿类
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.employee
 * @Title Programmer
 * @date 2020/6/24、19:52
 * @company 阿里巴巴
 */
public class Programmer extends Employee{

    private int memberId;                   //开发团队中的id
    private Status status = Status.FREE;    //员工的状态
    private Equipment equipment;            //员工的设备

    public Programmer() {
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription() ;
    }

    public String getDetail() {
        return memberId+"/"+"\t"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary();
    }
}
