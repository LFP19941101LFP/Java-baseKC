package com.alibaba.service;

import com.alibaba.employee.Architect;
import com.alibaba.employee.Designer;
import com.alibaba.employee.Employee;
import com.alibaba.employee.Programmer;

/**
 * @author LiFupeng
 * @version V1.0
 * @Package com.alibaba.service;
 * @Title TeamService
 * @date 2020/6/25、12:00
 * @company 阿里巴巴
 */
public class TeamService {
    private static int counter = 1; //给memberId赋值
    private final int MAX_MEMBER = 5; //限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER];//保存开发团队chengyuan
    private int total; //记录开发团队的人数

    /**
     * 获取开发团队的所有成员
     * @return
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0;i < team.length;i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    /**
     * 将指定员工添加到团队
     * @param employee
     */
    public void addMember(Employee employee) throws TeamException {
         //成员已满
        if (total >= MAX_MEMBER) {
            throw new TeamException("成员已满");
        }
        //该成员不是开发成员,无法添加
        if (!(employee instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员,无法添加");
        }
        //该员工已在开发团队中
        if (isExist(employee)) {
            throw new TeamException("该员工已在开发团队中,");
        }
        //该员工意识某个团队成员

        //正在休假,无法添加
        Programmer p = (Programmer)employee; //一定不会出现类型转换异常
        /*if ("BUSY".equals(p.getStatus().getNAME())) {  //(p.getStatus().getNAME().equals("BUSY"))
            throw new TeamException("员工在团队中");
        } else if("VOCATION".equals(p.getStatus().getNAME())) {
            throw new TeamException("员工正在休假");
        }*/
        switch (p.getStatus()) {
            case BUSY:
                throw new TeamException("员工在团队中");
            case VOCATION:
                throw new TeamException("员工正在休假");
        }
        /*
          团队最多只能有一个架构师
          团队最多只能有两个设计师
          团队最多只能有三个程序员
         */

        //获取team中已有的成员中的架构师,设计师,程序员
        int numOfArch = 0, numODes = 0, numOfPro = 0;
        for (int i = 0;i < total;i++) {
            if (team[i] instanceof Architect) {
                numOfArch++;
            } else if (team[i] instanceof Designer) {
                numODes++;
            } else if (team[i] instanceof Programmer) {
                numOfPro++;
            }
        }
        //架构师,程序员,设计师的选择
        if (p instanceof Architect) {
            if (numOfArch >= 1)
                throw new TeamException("团队中已有一个架构师");
        } else if (p instanceof Designer) {
            if (numODes >= 2)
                throw new TeamException("团队最多只能有两个设计师");
        } else if (p instanceof Programmer) {
            if (numOfPro >= 3)
                throw new TeamException("团队最多只能有三个程序员");
        }
        //选择将p或e添加到team中
        team[total++] = p;
        //p的属性赋值
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);
    }

    /**
     * 判断指定员工是否在指定团队中的方法
     * @param employee
     * @return
     */
    private boolean isExist(Employee employee) {
        for (int i = 0;i < total;i++) {
            return team[i].getId() == employee.getId();
        }
        return false;
    }

    /**
     * 将指定id员工从团队删除
     * @param member
     */
    public void removeMember(int member) throws TeamException {
        int i = 0;
        for (;i < total;i++) {
            if (team[i].getMemberId() == member) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        //未找到指定memberId的情况
        if (i == total) {
            throw new TeamException("团队最多只能有三个程序员");
        }
        //删除时后面的元素覆盖前面的元素
        for (int j = i+1;j < total;j++) {
            team[j-1] = team[j];
        }
        team[--total] = null; //将元素置空
    }
}
