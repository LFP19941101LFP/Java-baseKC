/*
Navicat MySQL Data Transfer

Source Server         : MySQL
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : ssm_crud

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-05-28 10:05:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tbl_dept
-- ----------------------------
DROP TABLE IF EXISTS `tbl_dept`;
CREATE TABLE `tbl_dept` (
  `dept_id` int(10) unsigned zerofill NOT NULL COMMENT '主键',
  `dept_name` varchar(10) NOT NULL COMMENT '部门',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_dept
-- ----------------------------
INSERT INTO `tbl_dept` VALUES ('0000000001', '人事部');
INSERT INTO `tbl_dept` VALUES ('0000000002', '财务部');
INSERT INTO `tbl_dept` VALUES ('0000000003', '研发部');
INSERT INTO `tbl_dept` VALUES ('0000000004', '董事会');
INSERT INTO `tbl_dept` VALUES ('0000000005', '销售部');
INSERT INTO `tbl_dept` VALUES ('0000000006', '测试部');

-- ----------------------------
-- Table structure for tbl_emp
-- ----------------------------
DROP TABLE IF EXISTS `tbl_emp`;
CREATE TABLE `tbl_emp` (
  `emp_id` int(10) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '员工id主键',
  `emp_name` varchar(10) NOT NULL COMMENT '姓名',
  `gender` varchar(2) NOT NULL COMMENT '性别',
  `email` varchar(15) NOT NULL COMMENT '邮箱',
  `d_id` int(10) NOT NULL COMMENT '外键',
  PRIMARY KEY (`emp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tbl_emp
-- ----------------------------
INSERT INTO `tbl_emp` VALUES ('0000000001', '李富鹏', 'M', '182325@qq.com', '4');
INSERT INTO `tbl_emp` VALUES ('0000000002', '雷丰阳', 'M', '1255425@qq.com', '3');
INSERT INTO `tbl_emp` VALUES ('0000000003', '李伟星', 'M', '854612@qq.com', '2');
INSERT INTO `tbl_emp` VALUES ('0000000004', '樊浩', 'F', '5446968@qq.com', '3');
INSERT INTO `tbl_emp` VALUES ('0000000005', '李向阳', 'M', '5411254@qq.com', '6');
INSERT INTO `tbl_emp` VALUES ('0000000006', '李富堂', 'M', '5465885@qq.com', '5');
INSERT INTO `tbl_emp` VALUES ('0000000007', '伏刚', 'M', '526694@qq.com', '2');
INSERT INTO `tbl_emp` VALUES ('0000000008', '蒋介石', 'F', '4155544@qq.com', '1');
INSERT INTO `tbl_emp` VALUES ('0000000009', '萨达姆', 'F', '845621@qq.com', '6');
INSERT INTO `tbl_emp` VALUES ('0000000010', '李乾斌', 'M', '652858@qq.com', '3');
INSERT INTO `tbl_emp` VALUES ('0000000011', '王喜全', 'M', '521569@qq.com', '6');
INSERT INTO `tbl_emp` VALUES ('0000000012', '祁龙龙', 'F', '521558@qq.com', '2');
INSERT INTO `tbl_emp` VALUES ('0000000013', '张豫宁', 'F', '559845@qq.com', '3');
INSERT INTO `tbl_emp` VALUES ('0000000014', '杨海宁', 'F', '6558456@qq.com', '5');
INSERT INTO `tbl_emp` VALUES ('0000000015', '马云', 'M', '1201254@qq.com', '3');
INSERT INTO `tbl_emp` VALUES ('0000000016', '雷军', 'M', '12545858@qq.com', '4');
INSERT INTO `tbl_emp` VALUES ('0000000017', '章泽天', 'F', '112544@qq.com', '5');
INSERT INTO `tbl_emp` VALUES ('0000000018', '刘强东', 'M', '522455@qq.com', '2');
INSERT INTO `tbl_emp` VALUES ('0000000019', '李向阳', 'M', '255899@qq.com', '3');
INSERT INTO `tbl_emp` VALUES ('0000000020', '李晓婷', 'F', '958554@qq.com', '1');
INSERT INTO `tbl_emp` VALUES ('0000000021', '张建龙', 'F', '542525@qq.com', '5');
INSERT INTO `tbl_emp` VALUES ('0000000022', '周阳', 'M', '521145@qq.com', '3');
INSERT INTO `tbl_emp` VALUES ('0000000023', '王莹莹', 'F', '125244@qq.com', '1');
INSERT INTO `tbl_emp` VALUES ('0000000024', '川普', 'F', '52148@qq.com', '5');
INSERT INTO `tbl_emp` VALUES ('0000000025', '王健林', 'M', '55155@qq.com', '2');
INSERT INTO `tbl_emp` VALUES ('0000000026', '李向前', 'M', '6325842@qq.com', '4');
