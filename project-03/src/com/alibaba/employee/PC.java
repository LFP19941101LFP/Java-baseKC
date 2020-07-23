package com.alibaba.employee;

/**
 * pc类实现设备接口
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.employee
 * @Title PC
 * @date 2020/6/24、19:40
 * @company 阿里巴巴
 */
public class PC implements Equipment {
    private  String model;//机器型号
    private String display;//表示显示器名称

    public PC() {
    }

    public PC(String model, String display) {
        this.model = model;
        this.display = display;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public String getDescription() {
        return model + display;
    }
}
