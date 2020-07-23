package com.alibaba.service;

/**
 * 员工的状态
 * @author LiFupeng
 * @version V1.0
 * @Package
 * @Title
 * @date 2020/6/24、19:56
 * @company 阿里巴巴
 */
/*
public class Status {
    private final String NAME;
    private Status(String name){
        this.NAME = name;
    }

    */
/**
     * FREE-空闲
     * BUSY-已加入开发团队
     * VOCATION-正在休假
     *//*

    public static  final Status FREE = new Status("FREE");
    public static  final Status BUSY = new Status("BUSY");
    public static  final Status VOCATION = new Status("VOCATION");

    public String getNAME(){
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
*/

public enum Status{
    FREE,BUSY,VOCATION;
}






















