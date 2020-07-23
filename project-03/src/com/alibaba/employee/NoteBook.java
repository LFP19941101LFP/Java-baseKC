package com.alibaba.employee;

/**
 * 笔记本类实现设备类
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.employee;
 * @Title NoteBook
 * @date 2020/6/24、19:44
 * @company 阿里巴巴
 */
public class NoteBook implements Equipment {

    private  String model;  //机器型号
    private  double price;  //价格
    //无参构造方法
    public NoteBook() {}
    //有参构造
    public NoteBook(String model,double price) {
        super();
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return null;
    }
}
