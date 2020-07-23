package com.alibaba.junit;

import com.alibaba.employee.Employee;
import com.alibaba.service.NameListService;
import com.alibaba.service.TeamException;
import org.junit.Test;

/**
 * 测试类
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.junit;
 * @Title  NameListTest
 * @date 2020/6/25、11:06
 * @company 阿里巴巴
 */
public class NameListTest {

    NameListService service = new NameListService();
    //测试获取
    @Test
    public void TestGetAllEmployees() {

        Employee[] allEmployees = service.getAllEmployees();
        for (int i = 0;i < allEmployees.length;i++) {
            System.out.println(allEmployees[i]);
        }
    }

    //测试获取指定id的员工
    @Test
    public void getEmployee() {
        int id = 20;
        try {
            Employee employee = service.getEmployee(id);
            System.out.println(employee);
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

    }
}
