package com.alibaba.employee;

/**
 * 设计师类
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.employee
 * @Title Designer
 * @date 2020/6/24、20:08
 * @company 阿里巴巴
 */
public class Designer extends Programmer {
    private double bonus; //奖金

    public Designer() {
    }

    public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
        super(id, name, age, salary, equipment);
        this.bonus = bonus;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public String toString() {
        return getDetails() + "\t设计师\t" + getStatus() + "\t" +
                getBonus() +"\t\t" + getEquipment().getDescription();
    }
    public String getDetail() {
        return getMemberId()+"/"+"\t"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t"+getBonus();
    }
}
