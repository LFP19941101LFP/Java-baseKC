package com.alibaba.service;

import com.alibaba.employee.*;

import static com.alibaba.service.Data.*;


/**
 * 负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.service
 * @Title NameListService
 * @date 2020/6/24、21:01
 * @company 阿里巴巴
 */
public class NameListService {

    //封装Employee用来保存公司所有员工对象
    private Employee[] employees;

    /**
     * 给数组和数组元素初始化
     * 根据项目提供的Data类构建相应大小的employees数组
     * 再根据Data类中的数据构建不同的对象，包括Employee、
     * Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
     * 将对象存于数组中
     *  Data类位于com.atguigu.team.service包中
     */
    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0;i < employees.length;i++) {
            //获取员工的类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //获取Employee的基本信息
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bonus);
                break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bonus,stock);
                break;
                default:
                    break;
            }
        }
    }

    /**
     * 获取指定index位置上的设备
      * @param index
     * @return
     */
    private Equipment createEquipment(int index) {
        int key = Integer.parseInt(EQUIPMENTS[index][0]);
        String model = EQUIPMENTS[index][1];
        switch (key) {
            case PC: //21
                String display = EQUIPMENTS[index][1];
                return new PC(model,display);
            case NOTEBOOK: //22
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                return new NoteBook(model,price);
            case PRINTER://23
                String type = EQUIPMENTS[index][2];
                return new Printer(model,type);
        }
        return null;
    }

    /**
     * 获取当前所有员工
     * @return
     */
    public Employee[] getAllEmployees() {
        return  employees;
    }

    /**
     * 找指定id的员工
     * @param id
     * @return
     */
    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0;i < employees.length;i++) {
            if (employees[i].getId() == id) { //id是基本数据类型使用 ==
                return employees[i];
            }
        }
        throw new TeamException("找不到指定员工");
    }

}
