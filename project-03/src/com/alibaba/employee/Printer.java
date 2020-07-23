package com.alibaba.employee;


/**
 * 打印机类实现设备接口
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.employee
 * @Title Printer
 * @date 2020/6/24、19:47
 * @company 阿里巴巴
 */
public class Printer implements Equipment{

    private String name; //打印机名称
    private String type; //打印机类型

    //有参构造
    public Printer() {}
    //无参构造
    public Printer(String name,String type) {
        super();
        this.name = name;
        this.type =type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    @Override
    public String getDescription() {
        return null;
    }
}
