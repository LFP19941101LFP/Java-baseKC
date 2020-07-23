package com.alibaba.view;

import com.alibaba.employee.Employee;
import com.alibaba.employee.Programmer;
import com.alibaba.service.NameListService;
import com.alibaba.service.TeamException;
import com.alibaba.service.TeamService;
import com.alibaba.utils.TSUtility;
import org.junit.experimental.theories.FromDataPoints;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.view
 * @Title TeanView
 * @date 2020/6/25、13:11
 * @company 阿里巴巴
 */
public class TeamView {
    private NameListService liService = new  NameListService();
    private TeamService tService = new TeamService();

    public void enterMainMenu( ) {
        boolean isFlag = true;
        char c = 0;
        do {
            if (c != '1') {
                listAllEmployee();
            }
            
            System.out.println("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
            c = TSUtility.readMenuSelection();
            switch (c) {
                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("是否要退出: Y / N");
                    char isExist = TSUtility.readConfirmSelection();
                    if (isExist == 'Y') {
                        isFlag = false;
                    }
                    break;
            }
        } while (isFlag);
    }

    /**
     * 显示所有的员工信息
     */
    public void listAllEmployee( ) {
        System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
        Employee[] employees = liService.getAllEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("公司没有员工");
        } else {
            System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
            for (int i = 0;i < employees.length;i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("-------------------------------------------------------------------------------");

    }

    /**
     * 获取团队列表
     */
    public void getTeam( ) {
        System.out.println("\n--------------------团队成员列表---------------------\n");
        Programmer[] team = tService.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("没有成员");
        } else {
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票");
            for (int i = 0;i < team.length;i++) {
                System.out.println(team[i].getDetail());
            }
        }
        System.out.println("\n----------------------------------------------------\n");
    }


    /**
     * 添加员工
     */
    public void addMember( ) {
        System.out.println("---------------------添加成员---------------------");
        System.out.println("请输入要添加的员工ID：");
        int anInt = TSUtility.readInt();
        Employee emp = null;
        try {
            emp = liService.getEmployee(anInt);
            tService.addMember(emp);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println("添加失败，原因："  + e.getMessage());
        }
        TSUtility.readReturn(); //添加成功后按回车继续
    }

    /**
     * 删除成员
     */
    public void deleteMember( ) {
        System.out.println("---------------------删除成员---------------------");
        System.out.print("请输入要删除员工的TID：");
        int memberId = TSUtility.readInt();
        System.out.println("确认是否删除(Y/N)：");
        char selection = TSUtility.readConfirmSelection();
        if (selection == 'N'){
            return;
        }

        try {
            tService.removeMember(memberId);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败," + e.getMessage());
        }
        TSUtility.readReturn(); //添加成功后按回车继续
    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();

    }
}
