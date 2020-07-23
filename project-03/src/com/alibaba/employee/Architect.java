package com.alibaba.employee;


/**
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.employee
 * @Title Architect
 * @date 2020/6/24、20:17
 * @company 阿里巴巴
 */
public class Architect extends Designer{
    private int stock; //表示公司奖励的股票数量

    public Architect() {
    }

    public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id, name, age, salary, equipment, bonus);
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return getDetails() + "\t架构师\t" + getStatus() + "\t" +
                getBonus() + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }

    public String getDetail() {
        return getMemberId()+"/"+"\t"+getId()+"\t"+getName()+"\t"+getAge()+"\t"+getSalary()+"\t架构师\t"+getBonus()+"\t"+getStock();
    }
}
